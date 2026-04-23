#!/usr/bin/env bash
set -euo pipefail

# ===========================================
# USO
# ===========================================
# Exemplo:
#   bash scripts/05_gerarRelatorioMutacao.sh exp06-primes Primes
#
# Argumentos:
#   1: diretório do experimento (ex.: exp06-primes)
#   2: nome da classe alvo (ex.: Primes)
# ===========================================

if [[ $# -lt 2 ]]; then
  echo "Uso: $0 <diretorio_experimento> <classe_alvo>"
  echo "Exemplo: $0 exp06-primes Primes"
  exit 1
fi

EXP_NAME="$1"
CLASSE_ALVO="$2"

EXP_DIR="experimentos/$EXP_NAME"
ABS_EXP_DIR="$(readlink -f "$EXP_DIR")"

# ===========================================
# PATHS
# ===========================================
FIXED_MUTANTS_DIR="$ABS_EXP_DIR/mutation-testing/fixed-mutants"

PIT_REPORT_DIR="$FIXED_MUTANTS_DIR/report"
XML_FILE="$PIT_REPORT_DIR/mutations.xml"

OPERATORS_REPORT_DIR="$FIXED_MUTANTS_DIR/mutation-operators-report"
OUT_CSV="$OPERATORS_REPORT_DIR/report-${CLASSE_ALVO}.csv"

mkdir -p "$OPERATORS_REPORT_DIR"

[[ -f "$XML_FILE" ]] || { echo "❌ Não encontrei $XML_FILE"; exit 1; }

# ===========================================
# GERA RELATÓRIO PARA A CLASSE ALVO
# ===========================================
python3 - "$XML_FILE" "$OUT_CSV" "$CLASSE_ALVO" <<'PY'
import sys, csv, xml.etree.ElementTree as ET

xml_path, out_csv, classe_alvo = sys.argv[1], sys.argv[2], sys.argv[3]

# ----------------------------------------------------------
# Classificação do tipo do operador (AJUSTADO)
# ----------------------------------------------------------
def classificar_tipo(mutator_fqcn: str) -> str:
    m = mutator_fqcn.lower()

    if "math" in m or "incre" in m:
        return "Arithmetic"

    if "condition" in m or "negate" in m or "remove_conditional" in m:
        return "Relational"

    # 🔥 AJUSTE PRINCIPAL (cobre todos os tipos de retorno)
    if "return" in m:
        return "Return"

    if "void" in m:
        return "Logical"

    if "null" in m:
        return "Null"

    return "Other"

# ----------------------------------------------------------
# Converte descrição do PIT para transformação (GENÉRICO)
# ----------------------------------------------------------
def descricao_para_codigo(desc: str) -> str:
    d = desc.lower()

    if "addition with subtraction" in d:
        return "x + y → x - y"

    if "subtraction with addition" in d:
        return "x - y → x + y"

    if "multiplication with division" in d:
        return "x * y → x / y"

    if "division with multiplication" in d:
        return "x / y → x * y"

    if "negated conditional" in d:
        return "if (cond) → if (!cond)"

    if "changed conditional boundary" in d:
        return "boundary condition change"

    if "increment" in d:
        return "increment modification"

    if "modulus" in d:
        return "modulus operation modified"

    if "bitwise" in d:
        return "bitwise operation modified"

    if "return" in d:
        return "return value modified"

    return desc

tree = ET.parse(xml_path)
root = tree.getroot()

dados = []
operator_map = {}
op_counter = 1
mutante_counter = 1

# ----------------------------------------------------------
# Extração do mutations.xml (AJUSTE ROBUSTO)
# ----------------------------------------------------------
for mut in root.findall("mutation"):

    source_file = mut.findtext("sourceFile", "").strip()

    # 🔥 ajuste leve de robustez
    if not source_file.endswith(f"{classe_alvo}.java"):
        continue

    mutator_full = mut.findtext("mutator", "").strip()
    mutator = mutator_full.split(".")[-1]  # simplificado

    method = mut.findtext("mutatedMethod", "").strip()
    line = mut.findtext("lineNumber", "").strip()
    desc = mut.findtext("description", "").strip()

    transformacao = descricao_para_codigo(desc)

    if mutator not in operator_map:
        operator_map[mutator] = f"OP{op_counter:02d}"
        op_counter += 1

    mutant_id = f"M{mutante_counter:03d}"
    mutante_counter += 1

    dados.append({
        "class": classe_alvo,
        "mutant_id": mutant_id,
        "operator_id": operator_map[mutator],
        "mutator": mutator,
        "operator_type": classificar_tipo(mutator),
        "method": method,
        "line": line,
        "transformation": transformacao
    })

# ----------------------------------------------------------
# Escrita do CSV final
# ----------------------------------------------------------
with open(out_csv, "w", newline='', encoding="utf-8") as f:
    w = csv.DictWriter(
        f,
        fieldnames=[
            "class",
            "mutant_id",
            "operator_id",
            "mutator",
            "operator_type",
            "method",
            "line",
            "transformation"
        ]
    )
    w.writeheader()
    w.writerows(dados)

print(f"✅ Relatório único gerado: {out_csv}")
PY

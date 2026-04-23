#!/usr/bin/env bash
set -euo pipefail

# ===========================================
# USO
# ===========================================
# Exemplo:
#   bash scripts/gerarMutantesFixosPit.sh exp06-primes experimento.base.PrimesBaseTest org.apache.commons.math3.primes
#
# Argumentos:
#   1: diretório do experimento (ex.: exp06-primes)
#   2: suíte base (Fully Qualified Name, ex.: experimento.base.PrimesBaseTest)
#   3: pacote da classe alvo (ex.: org.apache.commons.math3.primes)
# ===========================================

if [[ $# -lt 3 ]]; then
  echo "Uso: $0 <diretorio_experimento> <suite_base> <pacote_classe_alvo>"
  echo "Exemplo: $0 exp06-primes experimento.base.PrimesBaseTest org.apache.commons.math3.primes"
  exit 1
fi

# ===========================================
# CONFIGURAÇÕES
# ===========================================
EXP_NAME="$1"
SUITE_BASE="$2"
PKG_ALVO="$3"

EXP_DIR="experimentos/$EXP_NAME"
ABS_EXP_DIR="$(readlink -f "$EXP_DIR")"
VERBOSE="${VERBOSE:-false}"

TEST_DIR="$ABS_EXP_DIR/src/test/java"
QUARENTENA_DIR="$ABS_EXP_DIR/_tests_quarentena"

# >>> AJUSTES DE ORGANIZAÇÃO (APENAS AQUI) <<<
MUT_FIX_DIR="$ABS_EXP_DIR/mutation-testing/fixed-mutants"
REL_DIR="$MUT_FIX_DIR/report"
HISTORY_FILE="$MUT_FIX_DIR/pitHistory.bin"

TARGET_HISTORY="$ABS_EXP_DIR/target/pit-history/pitHistory.bin"
TARGET_REPORTS="$ABS_EXP_DIR/target/pit-reports"

# ===========================================
# PREPARA PASTAS
# ===========================================
echo "🔧 Preparando pastas..."
mkdir -p "$QUARENTENA_DIR" "$REL_DIR"

# Em caso de falha, restaurar testes movidos
restore_tests() { mv "$QUARENTENA_DIR"/*.java "$TEST_DIR"/ 2>/dev/null || true; }
trap restore_tests EXIT

# ===========================================
# ISOLA APENAS SUITE BASE
# ===========================================
echo "🧹 Movendo TEMPORARIAMENTE testes LLM para quarentena..."

# extrai apenas o nome simples da classe base
base_filename="$(echo "$SUITE_BASE" | sed 's/.*\.//').java"

moved=0
shopt -s nullglob
for f in "$TEST_DIR"/*[Tt]est.java; do
  if [[ "$(basename "$f")" != "$base_filename" ]]; then
    mv "$f" "$QUARENTENA_DIR"/
    moved=1
  fi
done
shopt -u nullglob

# ===========================================
# COMPILA
# ===========================================
echo "🏗️ Compilando (main + suíte base)..."
mvn -q -f "$ABS_EXP_DIR/pom.xml" -DskipTests test-compile

# ===========================================
# RODA PIT PARA GERAR MUTANTES FIXOS
# ===========================================
echo "🧬 Gerando MUTANTES FIXOS com a suíte base: $SUITE_BASE"
PIT_CMD=( mvn -f "$ABS_EXP_DIR/pom.xml" org.pitest:pitest-maven:mutationCoverage
          -DtestPlugin=junit5
          -DtargetTests="$SUITE_BASE"
          -DtargetClasses="$PKG_ALVO.*" )
[[ "$VERBOSE" == "true" ]] && PIT_CMD+=( -Dverbose=true -DdumpConfiguration=true )
"${PIT_CMD[@]}"

# ===========================================
# COPIA ARTEFATOS
# ===========================================
[[ -f "$TARGET_HISTORY" ]] || { echo "❌ Não encontrei $TARGET_HISTORY"; exit 1; }
[[ -f "$TARGET_REPORTS/mutations.xml" ]] || { echo "❌ Não encontrei mutations.xml no $TARGET_REPORTS"; exit 1; }

cp -f "$TARGET_HISTORY" "$HISTORY_FILE"
if command -v sha256sum >/dev/null 2>&1; then
  (cd "$MUT_FIX_DIR" && sha256sum pitHistory.bin > pitHistory.bin.sha256)
fi

TIMESTAMP="$(date -u +%Y%m%dT%H%M%SZ)"
cat > "$MUT_FIX_DIR/metadata.json" <<EOF
{
  "created_utc": "$TIMESTAMP",
  "suite_base": "$SUITE_BASE",
  "target_package": "$PKG_ALVO",
  "pit_plugin_version": "$(mvn -q -f "$ABS_EXP_DIR/pom.xml" help:evaluate -Dexpression=plugin.version -Dplugin=org.pitest:pitest-maven | grep -E '^[0-9]' || echo unknown)"
}
EOF

cp -f "$TARGET_REPORTS/index.html" "$REL_DIR/"
cp -f "$TARGET_REPORTS/mutations.xml" "$REL_DIR/"
cp -f "$TARGET_REPORTS/mutations.csv" "$REL_DIR/"
find "$TARGET_REPORTS" -name "*.java.html" -exec cp -f {} "$REL_DIR/" \;
[[ -f "$TARGET_REPORTS/style.css" ]] && cp -f "$TARGET_REPORTS/style.css" "$REL_DIR/"

# ===========================================
# RESTAURA TESTES
# ===========================================
echo "♻️ Restaurando testes LLM..."
if [[ $moved -eq 1 ]]; then
  mv "$QUARENTENA_DIR"/*.java "$TEST_DIR"/ 2>/dev/null || true
fi
trap - EXIT
rm -rf "$QUARENTENA_DIR"

# ===========================================
# RESUMO
# ===========================================
echo
echo "✅ Estrutura enxuta gerada em: $MUT_FIX_DIR"
echo "├── pitHistory.bin"
echo "├── pitHistory.bin.sha256"
echo "├── metadata.json"
echo "└── report/"
echo "    ├── index.html"
echo "    ├── mutations.xml"
echo "    ├── mutations.csv"
echo "    ├── *.java.html"
echo "    └── style.css"


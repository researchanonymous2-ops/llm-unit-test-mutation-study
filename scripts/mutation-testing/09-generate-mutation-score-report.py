#!/usr/bin/env python3
import pandas as pd
from pathlib import Path
import sys
import re

# ============================================================
# Parâmetros
# ============================================================
if len(sys.argv) < 3:
    print("Uso: python3 10-gerar-analise-quantitativa-mutantes.py <experimento> <classe>")
    sys.exit(1)

experimento = sys.argv[1]
classe = sys.argv[2]

# ============================================================
# Caminhos (PADRÃO NOVO)
# ============================================================
base_dir = Path(f"experimentos/{experimento}/mutation-testing/suites-execution-results")

out_dir = Path(
    f"experimentos/{experimento}/mutation-testing/quantitative-mutants-analysis"
)
out_dir.mkdir(parents=True, exist_ok=True)

print("\n📊 Gerando análise quantitativa de mutantes por suíte")
print(f"📘 Experimento : {experimento}")
print(f"🏷️ Classe      : {classe}")
print(f"📁 Entrada     : {base_dir}")
print(f"📁 Saída       : {out_dir}\n")

linhas = []

colunas_pit = [
    "Arquivo",
    "ClasseMutada",
    "Mutador",
    "MetodoMutado",
    "Linha",
    "Status",
    "TesteResponsavel"
]

# ============================================================
# Função: contagem correta de casos de teste por suíte
# ============================================================
def contar_test_cases_por_suite(experimento: str, suite_name: str) -> int:
    """
    Conta casos de teste de uma suíte específica.
    Um caso de teste = método anotado com @Test ou @ParameterizedTest
    no arquivo <suite_name>.java localizado em src/test/java.
    """
    src_test = Path(f"experimentos/{experimento}/src/test/java")
    padrao = re.compile(r"@\s*(Test|ParameterizedTest)\b")

    for java_file in src_test.rglob(f"{suite_name}.java"):
        try:
            conteudo = java_file.read_text(encoding="utf-8", errors="ignore")
            return len(padrao.findall(conteudo))
        except Exception:
            return 0

    return 0

# ============================================================
# Processamento por suíte
# ============================================================
if not base_dir.exists():
    print(f"❌ Diretório de entrada não encontrado: {base_dir}")
    sys.exit(1)

for suite_dir in sorted(base_dir.iterdir()):

    if not suite_dir.is_dir():
        continue

    mutations_path = suite_dir / "mutations.csv"
    if not mutations_path.exists():
        print(f"⚠️  mutations.csv não encontrado em {suite_dir}")
        continue

    try:
        # --------------------------------------------
        # Métricas de mutação
        # --------------------------------------------
        df = pd.read_csv(mutations_path, header=None, names=colunas_pit)

        mortos = ((df["Status"] == "KILLED") | (df["Status"] == "TIMED_OUT")).sum()
        sobreviventes = (df["Status"] == "SURVIVED").sum()
        nao_cobertos = (df["Status"] == "NO_COVERAGE").sum()

        total = len(df)
        exercitados = mortos + sobreviventes

        mutation_score = (mortos / total * 100) if total > 0 else 0
        test_strength = (mortos / exercitados * 100) if exercitados > 0 else 0

        # --------------------------------------------
        # Contagem de casos de teste (CORRETA)
        # --------------------------------------------
        test_cases = contar_test_cases_por_suite(experimento, suite_dir.name)

        linhas.append({
            "Suite": suite_dir.name,
            "Class": classe,
            "Test_Cases": test_cases,
            "Mutants": total,
            "Killed": mortos,
            "Survived": sobreviventes,
            "No_Coverage": nao_cobertos,
            "Mutation_Score (%)": round(mutation_score, 2),
            "Test_Strength (%)": round(test_strength, 2)
        })

        print(
            f"📂 {suite_dir.name} → "
            f"TC={test_cases} | "
            f"MS={mutation_score:.2f}% | TS={test_strength:.2f}% "
            f"(K:{mortos} S:{sobreviventes} NC:{nao_cobertos})"
        )

    except Exception as e:
        print(f"❌ Erro ao processar {suite_dir.name}: {e}")

# ============================================================
# Geração da Tabela Consolidada
# ============================================================
if linhas:
    df_final = pd.DataFrame(linhas)
    saida = out_dir / f"report-{classe}.csv"
    df_final.to_csv(saida, index=False)

    print(f"\n✅ Tabela salva em:")
    print(f"   {saida}\n")
else:
    print("\n⚠️ Nenhuma suíte com mutantes encontrados.\n")

print("🏁 Análise concluída.\n")


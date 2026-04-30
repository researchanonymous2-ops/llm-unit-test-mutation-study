#!/usr/bin/env bash
set -euo pipefail

# ===========================================
# USO
# ===========================================
# Exemplo:
#   bash scripts/mutacao/08-run-test-suites-on-mutants.sh \
#     exp-binarytree com.thealgorithms.datastructures.trees.BinaryTree
# ===========================================

if [[ $# -lt 2 ]]; then
  echo "Uso: $0 <diretorio_experimento> <classe_alvo_FQN>"
  exit 1
fi

EXP_NAME="$1"
CLASSE_ALVO="$2"

EXP_DIR="experimentos/$EXP_NAME"
ABS_EXP_DIR="$(readlink -f "$EXP_DIR")"

# ===========================================
# PATHS (PADRÃO NOVO)
# ===========================================
HISTORY_FILE="$ABS_EXP_DIR/mutation-testing/fixed-mutants/pitHistory.bin"
RESULTADOS_DIR="$ABS_EXP_DIR/mutation-testing/suites-execution-results"

[[ -f "$HISTORY_FILE" ]] || { echo "❌ Não encontrei $HISTORY_FILE"; exit 1; }

mkdir -p "$RESULTADOS_DIR"

# ===========================================
# LOCALIZA O PACOTE DOS TESTES
# ===========================================
# Ex.: com.thealgorithms.datastructures.trees.BinaryTree
PKG="$(echo "$CLASSE_ALVO" | sed 's/\(.*\)\.[^.]*$/\1/')"
PKG_PATH="$(echo "$PKG" | sed 's/\./\//g')"

TEST_CLASSES_DIR="$ABS_EXP_DIR/target/test-classes/$PKG_PATH"

if [[ ! -d "$TEST_CLASSES_DIR" ]]; then
  echo "❌ Diretório de classes de teste não encontrado:"
  echo "   $TEST_CLASSES_DIR"
  exit 1
fi

echo "📦 Diretório de testes detectado: $TEST_CLASSES_DIR"

# ===========================================
# IDENTIFICA SUÍTES ELEGÍVEIS (somente LLMs)
# ===========================================
SUITES=()

while IFS= read -r classfile; do
  suite="$(basename "$classfile" .class)"

  # Ignorar suite base
  if [[ "$suite" == *BaseTest ]]; then
    continue
  fi

  SUITES+=("$suite")
done < <(find "$TEST_CLASSES_DIR" -maxdepth 1 -name "*Test.class")

if [[ ${#SUITES[@]} -eq 0 ]]; then
  echo "❌ Nenhuma suíte LLM encontrada."
  exit 1
fi

echo "✅ Suítes elegíveis:"
printf '  - %s\n' "${SUITES[@]}"

# ===========================================
# EXECUTA PIT PARA CADA SUITE
# ===========================================
for SUITE in "${SUITES[@]}"; do
  echo
  echo "🧪 Rodando PIT para suíte: $SUITE"

  OUT_DIR="$RESULTADOS_DIR/$SUITE"
  mkdir -p "$OUT_DIR"

  mvn -q -f "$ABS_EXP_DIR/pom.xml" org.pitest:pitest-maven:mutationCoverage \
    -DtestPlugin=junit5 \
    -DtargetTests="$PKG.$SUITE" \
    -DtargetClasses="$CLASSE_ALVO*" \
    -DhistoryInputFile="$HISTORY_FILE" \
    -DhistoryOutputFile="$HISTORY_FILE" \
    -DtimestampedReports=false \
    -DoutputFormats=XML,HTML,CSV \
    -DreportsDirectory="$OUT_DIR"

  echo "📊 Relatório salvo em: $OUT_DIR"
done

echo
echo "✅ Execução concluída. Relatórios em: $RESULTADOS_DIR"


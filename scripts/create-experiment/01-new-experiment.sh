#!/bin/bash

# =====================================================
# Script: novoExperimento.sh
# Uso: bash scripts/novoExperimento.sh <nome_experimento> <nome_classe>
# Exemplo: bash scripts/novoExperimento.sh exp15-binarytree BinaryTree
# =====================================================

if [ $# -lt 2 ]; then
  echo "Uso: $0 <nome_experimento> <nome_classe>"
  echo "Exemplo: $0 exp15-binarytree BinaryTree"
  exit 1
fi

NOME_EXP=$1
NOME_CLASSE=$2
EXP_DIR="experimentos/$NOME_EXP"

echo "📂 Criando novo experimento em $EXP_DIR ..."
mkdir -p "$EXP_DIR"

# Copia o pom.xml base da pasta templates
cp templates/pom.xml "$EXP_DIR/pom.xml"

# Estrutura para classes alvo
mkdir -p "$EXP_DIR/src/main/java"

# Estrutura para testes (package real será criado depois automaticamente)
mkdir -p "$EXP_DIR/src/test/java"

# Estrutura de prompts
mkdir -p "$EXP_DIR/prompts"

# Criação dos prompts padrão
echo "Gere uma suíte de testes JUnit 5 para a classe $NOME_CLASSE usando estratégia Zero-Shot." \
  > "$EXP_DIR/prompts/zero-shot.txt"

echo "Gere uma suíte de testes JUnit 5 para a classe $NOME_CLASSE usando estratégia One-Shot." \
  > "$EXP_DIR/prompts/one-shot.txt"  

echo "Gere uma suíte de testes JUnit 5 para a classe $NOME_CLASSE usando estratégia Few-Shot." \
  > "$EXP_DIR/prompts/few-shot.txt"  

echo "Gere uma suíte de testes JUnit 5 para a classe $NOME_CLASSE usando estratégia POT." \
  > "$EXP_DIR/prompts/pot.txt"

echo "Gere uma suíte de testes JUnit 5 para a classe $NOME_CLASSE usando estratégia CoC." \
  > "$EXP_DIR/prompts/coc.txt"

# Permissões amplas
chmod -R 777 "$EXP_DIR"
umask 000

echo "✅ Estrutura criada com sucesso!"
echo ""
echo "👉 Agora copie a classe alvo ($NOME_CLASSE.java) para:"
echo "   $EXP_DIR/src/main/java/"
echo "   (mantendo a estrutura de pacote original, ex.: com/thealgorithms/.../BinaryTree.java)"
echo ""
echo "👉 Após copiar a classe alvo, crie a SUÍTE BASE em:"
echo "   $EXP_DIR/src/test/java/<MESMO PACKAGE DA CLASSE ALVO>/${NOME_CLASSE}BaseTest.java"
echo ""
echo "👉 Depois disso, já pode chamar o script:"
echo "   python3 scripts/testes/02-gerar-testes.py $NOME_EXP $NOME_CLASSE <modelo> <llm> <estrategia>"
echo ""


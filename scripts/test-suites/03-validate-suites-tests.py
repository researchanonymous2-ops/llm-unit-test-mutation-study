#!/usr/bin/env python3
import os
import sys
import subprocess
import shutil
import re

# ============================================================
# PARÂMETROS GERAIS
# ============================================================
if len(sys.argv) < 3:
    print("Uso: python3 validate-suites-tests.py <nome_experimento> <nome_classe>")
    print("Exemplo: python3 validate-suites-tests.py exp15-binarytree BinaryTree")
    sys.exit(1)

EXP_NAME = sys.argv[1]
CLASS_NAME = sys.argv[2]

EXPERIMENTO_PATH = f"/app/experimentos/{EXP_NAME}"
SRC_MAIN = os.path.join(EXPERIMENTO_PATH, "src", "main", "java")

# ============================================================
# NOVA RAIZ DE VALIDAÇÃO (CRIADA SEMPRE)
# ============================================================
VALIDATION_DIR = os.path.join(EXPERIMENTO_PATH, "test-suite-validation")
os.makedirs(VALIDATION_DIR, exist_ok=True)

LOG_COMPILACAO_ERR = os.path.join(
    VALIDATION_DIR, "logs-suites", "compilation", "failed"
)
LOG_TESTES_ERR = os.path.join(
    VALIDATION_DIR, "logs-suites", "execution", "failed"
)
QUARENTENA = os.path.join(
    VALIDATION_DIR, "non-eligible-suites"
)

TEMP_COMPILE_DIR = os.path.join(EXPERIMENTO_PATH, "temp_compile")
CLASSPATH_FILE = os.path.join(EXPERIMENTO_PATH, "classpath.txt")

# Criar diretórios necessários
for path in [
    TEMP_COMPILE_DIR,
    LOG_COMPILACAO_ERR,
    LOG_TESTES_ERR,
    QUARENTENA
]:
    os.makedirs(path, exist_ok=True)

print(f"🔍 Verificando elegibilidade das suítes de teste para {CLASS_NAME}...\n")

# ============================================================
# FUNÇÃO: Localizar classe alvo e extrair pacote
# ============================================================
def localizar_classe(SRC_MAIN, class_name):
    for root, _, files in os.walk(SRC_MAIN):
        if f"{class_name}.java" in files:
            return os.path.join(root, f"{class_name}.java")
    return None

caminho_classe = localizar_classe(SRC_MAIN, CLASS_NAME)
if not caminho_classe:
    print(f"❌ Classe {CLASS_NAME}.java não encontrada em {SRC_MAIN}")
    sys.exit(1)

with open(caminho_classe, "r", encoding="utf-8") as f:
    conteudo_classe = f.read()

match_pkg = re.search(r'package\s+([\w\.]+);', conteudo_classe)
if not match_pkg:
    print("❌ Não foi possível extrair o pacote da classe alvo.")
    sys.exit(1)

PACKAGE_ALVO = match_pkg.group(1)
SRC_TEST = os.path.join(
    EXPERIMENTO_PATH,
    "src", "test", "java",
    PACKAGE_ALVO.replace(".", "/")
)

print(f"📦 Diretório de testes detectado: {SRC_TEST}\n")

if not os.path.exists(SRC_TEST):
    print(f"❌ Diretório de testes não encontrado: {SRC_TEST}")
    sys.exit(1)

# ============================================================
# GERA CLASSPATH VIA MAVEN
# ============================================================
print("🐧 Gerando classpath com dependências...")

classpath_cmd = ["mvn", "dependency:build-classpath", "-Dmdep.outputFile=./classpath.txt"]
result = subprocess.run(classpath_cmd, cwd=EXPERIMENTO_PATH, capture_output=True, text=True)

if result.returncode != 0:
    print("❌ Erro ao gerar classpath com Maven:")
    print(result.stdout)
    print(result.stderr)
    sys.exit(1)

with open(CLASSPATH_FILE, "r") as f:
    maven_classpath = f.read().strip()

full_classpath = os.pathsep.join([maven_classpath, SRC_MAIN, SRC_TEST])

# ============================================================
# COMPILA CLASSES DO MAIN
# ============================================================
arquivos_main = []
for root, _, files in os.walk(SRC_MAIN):
    for f in files:
        if f.endswith(".java"):
            arquivos_main.append(os.path.join(root, f))

print("\n🛠️ Compilando classes do main...\n")
result = subprocess.run(
    ["javac", "-cp", full_classpath, "-d", TEMP_COMPILE_DIR] + arquivos_main,
    capture_output=True, text=True
)

if result.returncode != 0:
    print("❌ Erro na compilação do main. Abortando.")
    sys.exit(1)

# ============================================================
# FUNÇÕES AUXILIARES (INALTERADAS)
# ============================================================
def get_fqcn(arquivo_suite):
    with open(arquivo_suite, "r") as f:
        conteudo = f.read()

    package_match = re.search(r'package\s+([\w\.]+);', conteudo)
    package = package_match.group(1) if package_match else ""

    class_match = re.search(r'class\s+(\w+)', conteudo)
    class_name = class_match.group(1) if class_match else os.path.basename(arquivo_suite).replace(".java", "")

    return f"{package}.{class_name}" if package else class_name


def compila_com_javac(arquivo_suite, nome_suite):
    comando = [
        "javac",
        "-cp", full_classpath,
        "-d", TEMP_COMPILE_DIR,
        arquivo_suite
    ]

    result = subprocess.run(comando, capture_output=True, text=True)

    if result.returncode != 0 or re.search(r"\berror:", result.stderr, re.IGNORECASE):
        log_path = os.path.join(LOG_COMPILACAO_ERR, nome_suite.replace(".java", ".log"))
        with open(log_path, "w") as log:
            log.write(result.stdout + "\n" + result.stderr)
        return False

    return True


def maven_result_is_success(saida_completa, surefire_dir):
    termos_falha = [
        "BUILD FAILURE",
        "There are test failures",
        "AssertionFailedError",
        "COMPILATION ERROR",
        "FAILURE!",
        "ERROR"
    ]
    if any(t in saida_completa for t in termos_falha):
        return False

    match_tests = re.search(r"Tests run:\s*(\d+)", saida_completa)
    if not match_tests or int(match_tests.group(1)) == 0:
        return False

    if os.path.exists(surefire_dir):
        for arquivo in os.listdir(surefire_dir):
            if arquivo.endswith(".txt"):
                with open(os.path.join(surefire_dir, arquivo)) as f:
                    conteudo = f.read()
                    if re.search(r"Failures:\s*[1-9]", conteudo):
                        return False
                    if re.search(r"Errors:\s*[1-9]", conteudo):
                        return False

    return True

# ============================================================
# FASE 1 — COMPILAÇÃO DAS SUÍTES
# ============================================================
print("\n⚙️  Fase 1: Compilando suítes individualmente...\n")

testes = [
    os.path.join(SRC_TEST, f)
    for f in os.listdir(SRC_TEST)
    if f.endswith(".java") and "BaseTest" not in f
]

compiladas = []
falhas_compilacao = []

for caminho_suite in testes:
    nome_suite = os.path.basename(caminho_suite)
    if compila_com_javac(caminho_suite, nome_suite):
        print(f"✅ Compilou: {nome_suite}")
        compiladas.append(caminho_suite)
    else:
        print(f"❌ Erro de compilação: {nome_suite}")
        shutil.move(caminho_suite, os.path.join(QUARENTENA, nome_suite))
        falhas_compilacao.append(nome_suite)

print(f"\n📦 Total compiladas: {len(compiladas)} | Falharam: {len(falhas_compilacao)}")

# ============================================================
# FASE 2 — EXECUÇÃO MAVEN
# ============================================================
print("\n🚀 Fase 2: Executando testes Maven...\n")

elegiveis = []
falhas_execucao = []

for caminho_suite in compiladas:
    nome_suite = os.path.basename(caminho_suite)
    fqcn = get_fqcn(caminho_suite)

    surefire_dir = os.path.join(EXPERIMENTO_PATH, "target", "surefire-reports")
    if os.path.exists(surefire_dir):
        shutil.rmtree(surefire_dir)

    result = subprocess.run(
        ["mvn", "test", f"-Dtest={fqcn}", "-Dmaven.test.failure.ignore=false"],
        cwd=EXPERIMENTO_PATH,
        capture_output=True,
        text=True
    )

    saida_completa = result.stdout + result.stderr
    sucesso = maven_result_is_success(saida_completa, surefire_dir)

    if sucesso:
        print(f"✅ Testes passaram: {nome_suite}")
        elegiveis.append(nome_suite)
    else:
        log_path = os.path.join(LOG_TESTES_ERR, nome_suite.replace(".java", ".log"))
        with open(log_path, "w") as log:
            log.write("[STATUS] ERRO DE TESTE OU SUÍTE VAZIA\n\n")
            log.write(saida_completa)

        print(f"❌ Falha detectada: {nome_suite}")
        shutil.move(caminho_suite, os.path.join(QUARENTENA, nome_suite))
        falhas_execucao.append(nome_suite)

# ============================================================
# LIMPEZA FINAL E RESUMO
# ============================================================
shutil.rmtree(TEMP_COMPILE_DIR)
if os.path.exists(CLASSPATH_FILE):
    os.remove(CLASSPATH_FILE)

print("\n📋 RESUMO FINAL")
print(f"✅ Elegíveis: {len(elegiveis)}")
print(f"❌ Falhas de compilação: {len(falhas_compilacao)}")
print(f"❌ Falhas de teste (ou suítes vazias): {len(falhas_execucao)}")
print(f"🧩 Total analisadas: {len(testes)}")

if falhas_compilacao or falhas_execucao:
    print("\n🚫 Suítes movidas para non-eligible-suites:")
    for nome in falhas_compilacao + falhas_execucao:
        print(" -", nome)


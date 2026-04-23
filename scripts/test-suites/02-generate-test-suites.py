#!/usr/bin/env python3
import os
import sys
import requests
import re
import time
import csv

# =============================
# PARÂMETROS
# =============================

if len(sys.argv) < 6:
    print("Uso: python3 scripts/testes/02-gerar-suites-testes.py <nome_experimento> <nome_classe> <modelo_api> <llm_nome> <estrategia>")
    sys.exit(1)

EXP_NAME = sys.argv[1]
CLASS_NAME = sys.argv[2]
MODEL = sys.argv[3]
LLM_NAME = sys.argv[4]      # grok | llama | qwen
ESTRATEGIA = sys.argv[5]

BASE_DIR = f"experimentos/{EXP_NAME}"
SRC_MAIN = f"{BASE_DIR}/src/main/java"
PROMPT_FILE = f"{BASE_DIR}/prompts/{ESTRATEGIA}.txt"
CSV_PATH = os.path.join(BASE_DIR, "custos_llms.csv")

# =============================
# CUSTOS (OPENROUTER)
# =============================

USD_TO_BRL = 5.36  # cotação fixa em 15/01/2026

CUSTOS_MODELOS = {
    "grok":  {"prompt": 0.20, "completion": 1.50},
    "llama": {"prompt": 0.15, "completion": 0.60},
    "qwen":  {"prompt": 0.22, "completion": 0.95}
}

# =============================
# OPENROUTER
# =============================

API_KEY = os.getenv("OPENROUTER_API_KEY")
if not API_KEY:
    raise ValueError("❌ Variável de ambiente OPENROUTER_API_KEY ausente.")

ENDPOINT = "https://openrouter.ai/api/v1/chat/completions"
HEADERS = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json"
}

# =============================
# FUNÇÕES AUXILIARES
# =============================

def comentar_texto_nao_codigo(texto):
    linhas = texto.splitlines()
    novo = []
    dentro_codigo = False
    for linha in linhas:
        if linha.strip().startswith("```"):
            dentro_codigo = not dentro_codigo
            novo.append("// " + linha)
            continue
        novo.append(linha if dentro_codigo else ("// " + linha))
    return "\n".join(novo).strip()


def localizar_classe_alvo(src_dir, class_name):
    for root, _, files in os.walk(src_dir):
        if f"{class_name}.java" in files:
            return os.path.join(root, f"{class_name}.java")
    return None


def extrair_package(conteudo):
    m = re.search(r'package\s+([\w\.]+);', conteudo)
    return m.group(1) if m else None


def corrigir_nome_classe(conteudo, class_name_final):
    padrao = r'\b(public\s+|protected\s+|private\s+|abstract\s+|final\s+)*class\s+\w+'
    if re.search(padrao, conteudo):
        return re.sub(padrao, f'public class {class_name_final}', conteudo)
    return conteudo + f"\n\npublic class {class_name_final} {{ }}\n"


def chamar_openrouter(prompt_final):
    for tentativa in range(1, 6):
        try:
            resp = requests.post(
                ENDPOINT,
                headers=HEADERS,
                json={
                    "model": MODEL,
                    "messages": [{"role": "user", "content": prompt_final}],
                    "temperature": 0.0,
                    "max_tokens": 10000
                },
                timeout=300
            )
            data = resp.json()
            if "choices" not in data:
                time.sleep(3 * tentativa)
                continue
            return data
        except Exception:
            time.sleep(3 * tentativa)
    sys.exit("❌ Falha ao contatar API.")


def atualizar_csv(total_prompt, total_completion, total_tokens):
    # custos parciais (arredondados primeiro)
    custo_prompt = round(
        (total_prompt / 1_000_000) * CUSTOS_MODELOS[LLM_NAME]["prompt"], 6
    )
    custo_completion = round(
        (total_completion / 1_000_000) * CUSTOS_MODELOS[LLM_NAME]["completion"], 6
    )

    # custo total = soma dos arredondados
    custo_total = round(custo_prompt + custo_completion, 6)
    custo_total_brl = round(custo_total * USD_TO_BRL, 6)

    linhas = []

    # carregar CSV existente (descartando header e TOTAL)
    if os.path.exists(CSV_PATH):
        with open(CSV_PATH, newline="") as f:
            reader = csv.reader(f)
            next(reader, None)  # descarta cabeçalho
            linhas = [row for row in reader if row and row[2] != "TOTAL"]

    # adicionar linha da execução atual
    linhas.append([
        EXP_NAME, CLASS_NAME, LLM_NAME.capitalize(), ESTRATEGIA, 5,
        total_prompt, total_completion, total_tokens,
        f"{custo_prompt:.6f}", f"{custo_completion:.6f}",
        f"{custo_total:.6f}", f"{custo_total_brl:.6f}"
    ])

    # calcular TOTAL
    total_suites = 0
    total_prompt_sum = total_completion_sum = total_tokens_sum = 0
    total_cp = total_cc = total_ct = total_brl = 0.0

    for r in linhas:
        total_suites += int(r[4])
        total_prompt_sum += int(r[5])
        total_completion_sum += int(r[6])
        total_tokens_sum += int(r[7])
        total_cp += float(r[8])
        total_cc += float(r[9])
        total_ct += float(r[10])
        total_brl += float(r[11])

    linhas.append([
        EXP_NAME, CLASS_NAME, "TOTAL", "ALL", total_suites,
        total_prompt_sum, total_completion_sum, total_tokens_sum,
        f"{total_cp:.6f}", f"{total_cc:.6f}",
        f"{total_ct:.6f}", f"{total_brl:.6f}"
    ])

    # escrever CSV
    with open(CSV_PATH, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow([
            "experiment","class","model","prompt_strategy","total_suites",
            "prompt_tokens","completion_tokens","total_tokens",
            "cost_prompt_usd","cost_completion_usd",
            "cost_total_usd","cost_total_brl"
        ])
        writer.writerows(linhas)

# =============================
# EXECUÇÃO PRINCIPAL
# =============================

caminho_classe = localizar_classe_alvo(SRC_MAIN, CLASS_NAME)
if not caminho_classe:
    sys.exit("❌ Classe alvo não encontrada.")

with open(caminho_classe, "r", encoding="utf-8") as f:
    conteudo_classe = f.read()

PACKAGE = extrair_package(conteudo_classe)
saida_dir = os.path.join(BASE_DIR, "src", "test", "java", PACKAGE.replace(".", "/"))
os.makedirs(saida_dir, exist_ok=True)

with open(PROMPT_FILE, "r", encoding="utf-8") as f:
    prompt_base = f.read()

prompt_final = f"{prompt_base}\n\nAqui está a classe alvo:\n\n{conteudo_classe}"

sufixos = {"zero-shot":"ZS","one-shot":"OS","few-shot":"FS","pot":"POT","coc":"COC"}
sufixo = sufixos.get(ESTRATEGIA,"X")

total_prompt = total_completion = total_tokens = 0

for i in range(1, 6):
    print(f"\n--- Execução {i} ({LLM_NAME} - {ESTRATEGIA}) ---")

    data = chamar_openrouter(prompt_final)
    bruto = data["choices"][0]["message"]["content"]
    conteudo = comentar_texto_nao_codigo(bruto)

    usage = data.get("usage", {})
    total_prompt += usage.get("prompt_tokens", 0)
    total_completion += usage.get("completion_tokens", 0)
    total_tokens += usage.get("total_tokens", 0)

    conteudo = re.sub(r'^\s*package\s+[\w\.]+;\s*', '', conteudo, flags=re.MULTILINE)
    conteudo = f"package {PACKAGE};\n\n{conteudo}"

    class_name_final = f"{CLASS_NAME}{LLM_NAME.capitalize()}_{sufixo}{i}Test"
    conteudo = corrigir_nome_classe(conteudo, class_name_final)

    caminho_out = os.path.join(saida_dir, f"{class_name_final}.java")
    with open(caminho_out, "w") as f:
        f.write(conteudo)

    print(f"✅ Arquivo salvo: {caminho_out}")

# =============================
# RESUMO + CSV
# =============================

print("\n==============================")
print("📊 Tokens totais:")
print(f"Prompt: {total_prompt}")
print(f"Completion: {total_completion}")
print(f"Total: {total_tokens}")
print("==============================\n")

atualizar_csv(total_prompt, total_completion, total_tokens)


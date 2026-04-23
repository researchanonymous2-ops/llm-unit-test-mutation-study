#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Mapeia candidatos a mutantes equivalentes com base nos relatórios do PIT.
Gera um CSV detalhado por mutante, com totais e listas de suítes por status.

Obs:
- Comentários, funções e prints em português
- Artefatos (CSV) totalmente em inglês
"""

import os
import sys
import csv
import xml.etree.ElementTree as ET


# ---------------------------------------------------------
# Carregar mutantes fixos a partir do CSV (fixed-mutants)
# ---------------------------------------------------------
def carregar_mutantes_fixos(csv_file):
    mutantes = []
    with open(csv_file, newline="", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        for row in reader:
            mutantes.append(row)
    return mutantes


# ---------------------------------------------------------
# Coleta status de mutantes por suíte
# ---------------------------------------------------------
def coletar_status_mutantes(resultados_dir):
    """
    Percorre os relatórios mutations.xml e consolida o status final por mutante.

    Regras:
       KILLED > SURVIVED > NO_COVERAGE
       TIMED_OUT → KILLED
    """

    status_map = {}
    status_unicos = set()

    for suite in os.listdir(resultados_dir):

        xml_path = None
        for root_dir, _, files in os.walk(os.path.join(resultados_dir, suite)):
            if "mutations.xml" in files:
                xml_path = os.path.join(root_dir, "mutations.xml")
                break

        if not xml_path:
            continue

        try:
            tree = ET.parse(xml_path)
            root = tree.getroot()
        except Exception as e:
            print(f"⚠️ Erro ao ler XML em {suite}: {e}")
            continue

        mutantes_suíte = {}

        for mutation in root.findall("mutation"):

            # 🔥 AJUSTE PONTUAL (ESSENCIAL)
            mutator_full = mutation.findtext("mutator", "").strip()
            mutator = mutator_full.split(".")[-1]

            method = mutation.findtext("mutatedMethod", "").strip()
            line = mutation.findtext("lineNumber", "").strip()
            status = mutation.attrib.get("status", "").strip()

            if status == "TIMED_OUT":
                status = "KILLED"

            chave = (method, line, mutator)
            status_unicos.add(status)

            mutantes_suíte.setdefault(chave, set()).add(status)

        # -------------------------------------------------
        # Consolidação por prioridade de status
        # -------------------------------------------------
        for chave, statuses in mutantes_suíte.items():

            if "SURVIVED" in statuses:
                status_map.setdefault(chave, []).append({
                    "suite": suite,
                    "status": "SURVIVED"
                })

            if "KILLED" in statuses:
                status_map.setdefault(chave, []).append({
                    "suite": suite,
                    "status": "KILLED"
                })

            if statuses == {"NO_COVERAGE"}:
                status_map.setdefault(chave, []).append({
                    "suite": suite,
                    "status": "NO_COVERAGE"
                })

    return status_map, sorted(status_unicos)


# ---------------------------------------------------------
# Gerar relatório de candidatos a mutantes equivalentes
# ---------------------------------------------------------
def gerar_equivalentes(mutantes, status_map, status_unicos, out_csv, classe_alvo):

    campos = [
        "class",
        "mutant_id",
        "operator_id",
        "mutator",
        "method",
        "line",
        "equivalent_candidate",
        "total_survived_suites",
        "total_killed_suites",
        "total_no_coverage_suites",
        "killed_by_suites",
        "survived_in_suites",
        "no_coverage_suites"
    ]

    relatorio = []

    for m in mutantes:

        chave = (m["method"].strip(), m["line"].strip(), m["mutator"].strip())
        status_entries = status_map.get(chave, [])

        statuses = [s["status"] for s in status_entries]

        total_survived = statuses.count("SURVIVED")
        total_killed = statuses.count("KILLED")
        total_no_coverage = statuses.count("NO_COVERAGE")

        suites_killed = [s["suite"] for s in status_entries if s["status"] == "KILLED"]
        suites_survived = [s["suite"] for s in status_entries if s["status"] == "SURVIVED"]
        suites_no_coverage = [s["suite"] for s in status_entries if s["status"] == "NO_COVERAGE"]

        m["total_survived_suites"] = total_survived
        m["total_killed_suites"] = total_killed
        m["total_no_coverage_suites"] = total_no_coverage

        m["killed_by_suites"] = ", ".join(sorted(set(suites_killed))) if suites_killed else "-"
        m["survived_in_suites"] = ", ".join(sorted(set(suites_survived))) if suites_survived else "-"
        m["no_coverage_suites"] = ", ".join(sorted(set(suites_no_coverage))) if suites_no_coverage else "-"

        m["equivalent_candidate"] = (
            "Y" if total_survived > 0 and total_killed == 0 and total_no_coverage == 0 else "N"
        )

        relatorio.append(m)

    os.makedirs(os.path.dirname(out_csv), exist_ok=True)

    with open(out_csv, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=campos)
        writer.writeheader()
        for linha in relatorio:
            writer.writerow({k: linha.get(k, "") for k in campos})

    candidatos = [m for m in relatorio if m["equivalent_candidate"] == "Y"]

    print(f"\n📊 Status detectados: {', '.join(status_unicos)}")
    print(f"🔢 Total de mutantes analisados: {len(relatorio)}")
    print(f"💡 Candidatos a equivalentes: {len(candidatos)} "
          f"({(len(candidatos)/len(relatorio)*100 if relatorio else 0):.2f}%)")
    print(f"📝 Relatório salvo em: {out_csv}")


# ---------------------------------------------------------
# MAIN
# ---------------------------------------------------------
if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Uso: python3 mapear-mutantes-equivalentes.py <experimento> <ClasseAlvo>")
        sys.exit(1)

    experimento = sys.argv[1]
    classe_alvo = sys.argv[2]

    nome_classe = classe_alvo.split(".")[-1]

    base_dir = os.path.join("experimentos", experimento, "mutation-testing")

    relatorio_fixos = os.path.join(
        base_dir,
        "fixed-mutants",
        "mutation-operators-report",
        f"report-{nome_classe}.csv"
    )

    resultados_dir = os.path.join(
        base_dir,
        "suites-execution-results"
    )

    out_csv = os.path.join(
        base_dir,
        "equivalent-mutants-candidates",
        f"report-{nome_classe}.csv"
    )

    if not os.path.exists(relatorio_fixos):
        print(f"❌ Arquivo não encontrado: {relatorio_fixos}")
        sys.exit(1)

    if not os.path.isdir(resultados_dir):
        print(f"❌ Diretório de resultados não encontrado: {resultados_dir}")
        sys.exit(1)

    print("\n🔍 Iniciando mapeamento de candidatos a mutantes equivalentes")
    print(f"📘 Experimento : {experimento}")
    print(f"🏷️ Classe      : {classe_alvo}\n")

    mutantes = carregar_mutantes_fixos(relatorio_fixos)
    status_map, status_unicos = coletar_status_mutantes(resultados_dir)
    gerar_equivalentes(mutantes, status_map, status_unicos, out_csv, classe_alvo)

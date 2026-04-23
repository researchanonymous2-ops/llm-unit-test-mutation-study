#!/usr/bin/env python3
import csv
import re
import sys
from pathlib import Path
from collections import defaultdict

# ============================================================
# USAGE:
#   python3 scripts/testes/05-generate-quantitative-suites-report.py <experiment_name> <target_class>
# ============================================================

if len(sys.argv) < 3:
    print("Usage: python3 05-generate-quantitative-suites-report.py <experiment_name> <target_class>")
    sys.exit(1)

experiment = sys.argv[1]   # ex: exp19-primes
target_class = sys.argv[2] # ex: Primes

# ============================================================
# DIRECTORY CONFIGURATION
# ============================================================
base_dir = Path(f"experimentos/{experiment}")

src_main = base_dir / "src" / "main" / "java"
src_test_root = base_dir / "src" / "test" / "java"

# ============================================================
# TEST SUITE VALIDATION STRUCTURE
# ============================================================
validation_dir = base_dir / "test-suite-validation"

non_eligible_dir = validation_dir / "non-eligible-suites"

logs_root = validation_dir / "logs-suites"
compilation_failed_dir = logs_root / "compilation" / "failed"
execution_failed_dir = logs_root / "execution" / "failed"

output_dir = validation_dir / "suites-quantitative-report"
output_dir.mkdir(parents=True, exist_ok=True)

output_csv = output_dir / f"report-{target_class}.csv"

# ============================================================
# DETECT TARGET CLASS PACKAGE
# ============================================================
def detect_target_package():
    for file in src_main.rglob("*.java"):
        if file.name == f"{target_class}.java":
            content = file.read_text(encoding="utf-8")
            match = re.search(r'package\s+([\w\.]+);', content)
            if match:
                return match.group(1)
            raise ValueError("Unable to extract package from target class.")
    raise FileNotFoundError(f"Target class {target_class}.java not found in {src_main}")

TARGET_PACKAGE = detect_target_package()
eligible_tests_dir = src_test_root / TARGET_PACKAGE.replace(".", "/")

print(f"[INFO] Target class           : {target_class}")
print(f"[INFO] Detected package      : {TARGET_PACKAGE}")
print(f"[INFO] Eligible test suites  : {eligible_tests_dir}")
print(f"[INFO] Non-eligible suites   : {non_eligible_dir}")

# ============================================================
# EXTRACT MODEL AND PROMPT STRATEGY FROM SUITE NAME
# ============================================================
def extract_info(test_file):
    name = test_file.stem

    if name.startswith(target_class):
        name = name[len(target_class):]

    match = re.search(r"([A-Z][a-zA-Z0-9]+)_([A-Z]+)", name)
    if match:
        model = match.group(1)
        strategy_raw = match.group(2)
    else:
        model, strategy_raw = "Unknown", "NA"

    strategies_map = {
        "ZS": "Zero-shot",
        "OS": "One-shot",
        "FS": "Few-shot",
        "POT": "POT",
        "COC": "COC"
    }

    strategy = strategies_map.get(strategy_raw, strategy_raw)
    return model, strategy

# ============================================================
# DATA COLLECTION
# ============================================================
data = defaultdict(lambda: defaultdict(lambda: {
    "eligible": 0,
    "ineligible": 0,
    "non_compiling": 0,
    "runtime_failure": 0
}))

detected_models = set()

# ============================================================
# ELIGIBLE TEST SUITES
# ============================================================
if eligible_tests_dir.exists():
    for test_file in eligible_tests_dir.glob("*.java"):
        if "Base" in test_file.name:
            continue

        model, strategy = extract_info(test_file)
        data[model][strategy]["eligible"] += 1
        detected_models.add(model)

# ============================================================
# NON-ELIGIBLE TEST SUITES
# ============================================================
if non_eligible_dir.exists():
    for test_file in non_eligible_dir.rglob("*.java"):
        model, strategy = extract_info(test_file)
        data[model][strategy]["ineligible"] += 1
        detected_models.add(model)

# ============================================================
# NON-COMPILING SUITES (COMPILATION ERRORS)
# ============================================================
if compilation_failed_dir.exists():
    for log_file in compilation_failed_dir.glob("*.log"):
        model, strategy = extract_info(log_file)
        data[model][strategy]["non_compiling"] += 1
        detected_models.add(model)

# ============================================================
# RUNTIME FAILURE SUITES (EXECUTION ERRORS)
# ============================================================
if execution_failed_dir.exists():
    for log_file in execution_failed_dir.glob("*.log"):
        model, strategy = extract_info(log_file)
        data[model][strategy]["runtime_failure"] += 1
        detected_models.add(model)

detected_models = sorted(detected_models)

ordered_strategies = ["Zero-shot", "One-shot", "Few-shot", "POT", "COC"]

# ============================================================
# CSV GENERATION
# ============================================================
rows = []

for model in detected_models:
    for idx, strategy in enumerate(ordered_strategies):
        eligible = data[model][strategy]["eligible"]
        non_compiling = data[model][strategy]["non_compiling"]
        runtime_failure = data[model][strategy]["runtime_failure"]

        ineligible = non_compiling + runtime_failure
        total = eligible + ineligible

        rate = round((eligible / total) * 100, 1) if total > 0 else 0.0

        rows.append({
            "Class": target_class,
            "Model": model if idx == 0 else "",
            "Prompt Strategy": strategy,
            "Total Suites": total,
            "Non-compiling Suites": non_compiling,
            "Runtime-failure Suites": runtime_failure,
            "Eligible Suites": eligible,
            "Ineligible Suites": ineligible,
            "Eligibility Rate (%)": rate
        })

# ============================================================
# WRITE CSV
# ============================================================
if rows:
    with open(output_csv, "w", newline="", encoding="utf-8") as csvfile:
        writer = csv.DictWriter(csvfile, fieldnames=rows[0].keys())
        writer.writeheader()
        writer.writerows(rows)

    print(f"\n✅ Quantitative suite report generated successfully:")
    print(f"   {output_csv}\n")
else:
    print("⚠️ No test suites found to generate the report.")


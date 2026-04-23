#!/usr/bin/env python3
import os
import csv
import re
import sys

# =============================
# PARAMETERS
# =============================
if len(sys.argv) < 2:
    print("Usage: python3 04-generate-test-error-logs-report.py <experiment_name>")
    print("Example: python3 04-generate-test-error-logs-report.py exp19-primes")
    sys.exit(1)

EXP_NAME = sys.argv[1]

# ============================================================
# BASE DIRECTORY (NEW STRUCTURE)
# ============================================================
BASE_DIR = f"/app/experimentos/{EXP_NAME}/test-suite-validation/logs-suites"

paths = {
    "compilation": os.path.join(BASE_DIR, "compilation", "failed"),
    "execution": os.path.join(BASE_DIR, "execution", "failed")
}

print(f"\n🧾 Generating test error reports for experiment: {EXP_NAME}\n")

# =============================
# COMPILATION ERROR REPORT
# =============================
compilation_report = []

if os.path.exists(paths["compilation"]):
    for log_file in sorted(os.listdir(paths["compilation"])):
        if not log_file.endswith(".log"):
            continue

        suite = log_file.replace(".log", "")
        log_path = os.path.join(paths["compilation"], log_file)

        with open(log_path, "r", encoding="utf-8", errors="ignore") as f:
            lines = f.readlines()

        for i, line in enumerate(lines):
            m = re.search(r"(.+\.java):(\d+):\s*error:\s*(.*)", line)
            if m:
                line_number = m.group(2).strip()
                main_message = m.group(3).strip()

                source_code = ""
                if i + 1 < len(lines):
                    source_code = lines[i + 1].strip()

                details = []
                j = i + 2
                while j < len(lines) and lines[j].strip().startswith(
                    ("symbol:", "location:", "package")
                ):
                    details.append(lines[j].strip())
                    j += 1

                description = main_message
                if details:
                    description += " | " + " ".join(details)

                description = description.replace("\n", " ").replace("\r", " ").strip()

                compilation_report.append({
                    "test_suite": suite,
                    "line": line_number,
                    "source_code": source_code,
                    "description": description
                })

    if compilation_report:
        out_path = os.path.join(
            paths["compilation"],
            "compilation_errors_report.csv"
        )

        with open(out_path, "w", newline="", encoding="utf-8") as csvfile:
            writer = csv.DictWriter(
                csvfile,
                fieldnames=["test_suite", "line", "source_code", "description"],
                quoting=csv.QUOTE_ALL
            )
            writer.writeheader()
            writer.writerows(compilation_report)

        print(f"📄 Compilation error report saved at: {out_path}")
    else:
        print("✅ No compilation errors found.\n")
else:
    print("⚠️  Compilation log directory not found.\n")

# =============================
# EXECUTION ERROR REPORT
# =============================
execution_report = []

if os.path.exists(paths["execution"]):
    for log_file in sorted(os.listdir(paths["execution"])):
        if not log_file.endswith(".log"):
            continue

        suite = log_file.replace(".log", "")
        log_path = os.path.join(paths["execution"], log_file)

        with open(log_path, "r", encoding="utf-8", errors="ignore") as f:
            content = f.read()

        # Extract Surefire summary (INFO or ERROR)
        summary = re.search(
            r"(?:\[INFO\]|\[ERROR\])\s*Tests run:\s*(\d+),\s*Failures:\s*(\d+),\s*Errors:\s*(\d+),\s*Skipped:\s*(\d+)",
            content
        )

        if not summary:
            continue

        tests_run, failures, errors, skipped = summary.groups()

        # --- EMPTY SUITE (Tests run = 0) ---
        if tests_run == "0":
            execution_report.append({
                "test_suite": suite,
                "method": "-",
                "line": "-",
                "message": "EMPTY_SUITE: Tests run = 0 (suite did not execute any test cases)",
                "tests_run": tests_run,
                "failures": failures,
                "errors": errors,
                "skipped": skipped
            })
            continue

        # --- EXECUTION FAILURES ---
        for line in content.splitlines():
            line = line.strip()

            result_match = re.match(
                r"\[ERROR\]\s+([\w.$]+)\.(\w+):(\d+)\s+(.*)",
                line
            )

            if result_match:
                suite_name, method, line_no, msg = result_match.groups()

                execution_report.append({
                    "test_suite": suite_name,
                    "method": method,
                    "line": line_no,
                    "message": msg,
                    "tests_run": tests_run,
                    "failures": failures,
                    "errors": errors,
                    "skipped": skipped
                })

    if execution_report:
        out_path = os.path.join(
            paths["execution"],
            "execution_errors_report.csv"
        )

        with open(out_path, "w", newline="", encoding="utf-8") as csvfile:
            writer = csv.DictWriter(
                csvfile,
                fieldnames=[
                    "test_suite",
                    "method",
                    "line",
                    "message",
                    "tests_run",
                    "failures",
                    "errors",
                    "skipped"
                ],
                quoting=csv.QUOTE_ALL
            )
            writer.writeheader()
            writer.writerows(execution_report)

        print(f"📄 Execution error report saved at: {out_path}")
    else:
        print("✅ No execution errors found.\n")
else:
    print("⚠️  Execution log directory not found.\n")

# =============================
# FINAL SUMMARY
# =============================
print("\n===== SUMMARY =====")
print(f"Total compilation error records : {len(compilation_report)}")
print(f"Total execution error records   : {len(execution_report)}")
print("===================\n")


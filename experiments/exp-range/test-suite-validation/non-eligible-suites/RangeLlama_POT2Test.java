package org.apache.commons.lang3;

// ```json
{
  "semantic_roles": [
    {
      "name": "input_element",
      "description": "elemento fornecido como entrada ao método elementCompareTo"
    },
    {
      "name": "observable_return",
      "description": "valor inteiro retornado por elementCompareTo(input_element)"
    }
  ],
  "variables": [
    { "name": "element", "role": "parâmetro formal de entrada" }
  ],
  "definitions": [
    { "id": "D1", "variable": "element", "description": "definição inicial como parâmetro formal" }
  ],
  "uses": [
    {
      "id": "U1",
      "variable": "element",
      "type": "p-use",
      "description": "verificação de entrada nula (element == null)"
    },
    {
      "id": "U2",
      "variable": "element",
      "type": "p-use",
      "description": "decisão baseada no resultado de isAfter(element)"
    },
    {
      "id": "U3",
      "variable": "element",
      "type": "p-use",
      "description": "decisão baseada no resultado de isBefore(element)"
    }
  ],
  "du_paths": [
    {
      "id": "P0",
      "description": "element é nulo",
      "post_condition": "lançamento de NullPointerException"
    },
    {
      "id": "P1",
      "description": "element ocorre antes do intervalo",
      "post_condition": "retorno -1"
    },
    {
      "id": "P2",
      "description": "element ocorre após o intervalo",
      "post_condition": "retorno 1"
    },
    {
      "id": "P3",
      "description": "element ocorre dentro do intervalo",
      "post_condition": "retorno 0"
    }
  ],
  "planned_tests": [
    {
      "test_id": "T0",
      "covers": ["P0"],
      "asserts": ["NullPointerException lançada"]
    },
    {
      "test_id": "T1",
      "covers": ["P1"],
      "asserts": ["valor retornado == -1"]
    },
    {
      "test_id": "T2",
      "covers": ["P2"],
      "asserts": ["valor retornado == 1"]
    },
    {
      "test_id": "T3",
      "covers": ["P3"],
      "asserts": ["valor retornado == 0"]
    }
  ],
  "constraints": {
    "all_defs_covered": true,
    "all_p_uses_covered": true,
    "all_decision_outcomes_covered": true,
    "observable_contract_preserved": true
  }
}
// ```

public class RangeLlama_POT2Test { }

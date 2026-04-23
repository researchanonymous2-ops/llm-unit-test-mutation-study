package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PITest.
 * Objetivo exclusivo: executar linhas relevantes do método
 * multiply(BigDecimal[][], BigDecimal[][]) da classe MatrixUtil.
 */
public class MatrixUtilBaseTest {

    @Test
    void testMultiplyWithValidMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.valueOf(2) },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.valueOf(2), BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        // Garante apenas que o caminho válido foi executado
        assertTrue(result.isPresent());
    }

    @Test
    void testMultiplyWithInvalidMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.valueOf(2) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.valueOf(2) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        // Ativa o caminho que retorna Optional.empty()
        assertTrue(result.isEmpty());
    }
}


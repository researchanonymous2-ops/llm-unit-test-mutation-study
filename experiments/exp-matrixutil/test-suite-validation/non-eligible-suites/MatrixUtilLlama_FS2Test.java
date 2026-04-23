package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilLlama_FS2Test {

    @Test
    void testMultiply_WithCompatibleMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] expected = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertMatrixEquals(expected, result.get());
    }

    @Test
    void testMultiply_WithDifferentDimensionsReturnsEmpty() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ONE },
            { BigDecimal.ONE, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_WithSingleElementMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE }
        };

        BigDecimal[][] expected = {
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertMatrixEquals(expected, result.get());
    }

    @Test
    void testMultiply_WithNonSquareMatrices() {
        BigDecimal[][] matrix1 = {
            { new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3") },
            { new BigDecimal("4"), new BigDecimal("5"), new BigDecimal("6") }
        };

        BigDecimal[][] matrix2 = {
            { new BigDecimal("1"), new BigDecimal("2") },
            { new BigDecimal("3"), new BigDecimal("4") },
            { new BigDecimal("5"), new BigDecimal("6") }
        };

        BigDecimal[][] expected = {
            { new BigDecimal("22"), new BigDecimal("28") },
            { new BigDecimal("49"), new BigDecimal("64") }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertMatrixEquals(expected, result.get());
    }

    @Test
    void testMultiply_WithNullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_WithNullMatrix2() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = null;

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_WithEmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_WithEmptyMatrix2() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {};

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    private void assertMatrixEquals(BigDecimal[][] expected, BigDecimal[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}
// ```
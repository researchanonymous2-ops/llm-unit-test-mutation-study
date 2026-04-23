package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilLlama_FS1Test {

    @Test
    void testMultiplyWithCompatibleMatrices() {
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
    void testMultiplyWithDifferentDimensionsReturnsEmpty() {
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
    void testMultiplyWithSingleElementMatrices() {
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
    void testMultiplyWithNonSquareMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
            { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(7), BigDecimal.valueOf(8) },
            { BigDecimal.valueOf(9), BigDecimal.valueOf(10) },
            { BigDecimal.valueOf(11), BigDecimal.valueOf(12) }
        };

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(58), BigDecimal.valueOf(64) },
            { BigDecimal.valueOf(139), BigDecimal.valueOf(154) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertMatrixEquals(expected, result.get());
    }

    @Test
    void testMultiplyWithNullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiplyWithNullMatrix2() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE }
        };
        BigDecimal[][] matrix2 = null;

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiplyWithEmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiplyWithEmptyMatrix2() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE }
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
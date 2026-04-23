package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class MatrixUtilQwen_ZS3Test {

    @Test
    void testMultiply_validSquareMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(19), BigDecimal.valueOf(22)},
            {BigDecimal.valueOf(43), BigDecimal.valueOf(50)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_validNonSquareMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)},
            {BigDecimal.valueOf(9), BigDecimal.valueOf(10)},
            {BigDecimal.valueOf(11), BigDecimal.valueOf(12)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(58), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(139), BigDecimal.valueOf(154)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_withZeroMatrix() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_withIdentityMatrix() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ONE}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_matricesCannotBeMultiplied() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6), BigDecimal.valueOf(7)},
            {BigDecimal.valueOf(8), BigDecimal.valueOf(9), BigDecimal.valueOf(10)},
            {BigDecimal.valueOf(11), BigDecimal.valueOf(12), BigDecimal.valueOf(13)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_firstMatrixIsNull() {
        final BigDecimal[][] matrix1 = null;
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixIsNull() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = null;
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_bothMatricesAreNull() {
        final BigDecimal[][] matrix1 = null;
        final BigDecimal[][] matrix2 = null;
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptyMatrices() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {};
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_singleElementMatrices() {
        final BigDecimal[][] matrix1 = {{BigDecimal.valueOf(5)}};
        final BigDecimal[][] matrix2 = {{BigDecimal.valueOf(6)}};
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {{BigDecimal.valueOf(30)}};
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
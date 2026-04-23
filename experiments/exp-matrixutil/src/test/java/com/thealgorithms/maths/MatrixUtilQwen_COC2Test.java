package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;

public class MatrixUtilQwen_COC2Test {

    @Test
    void testMultiply_validMatrices_expectCorrectResult() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleDimensions_expectEmpty() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE},
            {BigDecimal.TEN},
            {BigDecimal.ZERO}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_singleElementMatrices_expectProduct() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(5)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(3)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(15)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_firstMatrixNull_expectEmpty() {
        final BigDecimal[][] matrix1 = null;
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixNull_expectEmpty() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE}
        };
        final BigDecimal[][] matrix2 = null;
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_bothMatricesNull_expectEmpty() {
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptyFirstMatrix_expectEmpty() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptySecondMatrix_expectEmpty() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE}
        };
        final BigDecimal[][] matrix2 = {};
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_nonSquareMatrices_expectCorrectResult() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4)}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(11)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_zeroMatrices_expectZeroResult() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ZERO},
            {BigDecimal.ZERO}
        };
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.ZERO}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
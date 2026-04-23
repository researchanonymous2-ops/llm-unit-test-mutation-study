package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class MatrixUtilQwen_COC5Test {

    @Test
    void testMultiply_validMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
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
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleDimensions() {
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
    void testMultiply_firstMatrixNull() {
        final BigDecimal[][] matrix1 = null;
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.TEN}
        };

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixNull() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN}
        };
        final BigDecimal[][] matrix2 = null;

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_bothMatricesEmpty() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {};

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_firstMatrixEmpty() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {{BigDecimal.ONE}};

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixEmpty() {
        final BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        final BigDecimal[][] matrix2 = {};

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_singleElementMatrices() {
        final BigDecimal[][] matrix1 = {{BigDecimal.valueOf(5)}};
        final BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {{BigDecimal.valueOf(15)}};
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_rectangularMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };

        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };

        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(9), BigDecimal.valueOf(12), BigDecimal.valueOf(15)},
            {BigDecimal.valueOf(19), BigDecimal.valueOf(26), BigDecimal.valueOf(33)},
            {BigDecimal.valueOf(29), BigDecimal.valueOf(40), BigDecimal.valueOf(51)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
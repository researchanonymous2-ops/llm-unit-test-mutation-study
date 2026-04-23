package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilQwen_ZS2Test {

    @Test
    void testMultiply_valid2x2Matrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(3), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(0), BigDecimal.valueOf(1)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(2), BigDecimal.valueOf(0)}
        };
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(7), BigDecimal.valueOf(9)},
            {BigDecimal.valueOf(2), BigDecimal.valueOf(0)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_valid3x3And3x2Matrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_singleElementMatrices() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(5)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        BigDecimal[][] expected = {{BigDecimal.valueOf(15)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleMatrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_nullFirstMatrix() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_nullSecondMatrix() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptyFirstMatrix() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptySecondMatrix() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_matricesWithZeroValues() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.valueOf(2), BigDecimal.ZERO}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.TEN}
        };
        BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.TEN},
            {BigDecimal.valueOf(2), BigDecimal.ZERO}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_negativeValues() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(-1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(-4)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(-6)},
            {BigDecimal.valueOf(-7), BigDecimal.valueOf(8)}
        };
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(-19), BigDecimal.valueOf(22)},
            {BigDecimal.valueOf(43), BigDecimal.valueOf(-50)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilQwen_ZS1Test {

    @Test
    void testMultiply_valid2x3And3x2Matrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_valid3x3And3x2Matrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
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
        BigDecimal[][] matrix1 = {{BigDecimal.TEN}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(5)}};
        BigDecimal[][] expected = {{BigDecimal.valueOf(50)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleMatrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ZERO}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_firstMatrixNull() {
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixNull() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_bothMatricesNull() {
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptyMatrices() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_firstMatrixEmpty() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixEmpty() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_matricesWithZeroValues() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.TEN, BigDecimal.ZERO}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.TEN}
        };
        BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.TEN},
            {BigDecimal.TEN, BigDecimal.ZERO}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilGrok_ZS1Test {

    @Test
    public void testMultiply_ValidMatrices() {
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
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testMultiply_IncompatibleMatrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    public void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    public void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    public void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = new BigDecimal[0][];
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    public void testMultiply_Matrix1WithEmptyRow() {
        BigDecimal[][] matrix1 = {new BigDecimal[0]};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    public void testMultiply_SmallMatrices() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(6)}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testMultiply_WithZeros() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.ONE, BigDecimal.ZERO}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ONE}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.ONE, BigDecimal.ZERO}
        };
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testMultiply_WithNegatives() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(-1)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(-2)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(2)}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    public void testMultiply_DifferentSizes() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE},
            {BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(14)}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }
}
// ```
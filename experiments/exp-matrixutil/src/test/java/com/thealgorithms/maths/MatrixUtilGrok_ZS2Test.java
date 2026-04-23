package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilGrok_ZS2Test {

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
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertTrue(java.util.Objects.deepEquals(expected, result.get()));
    }

    @Test
    public void testMultiply_IncompatibleDimensions() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE}
        };
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = new BigDecimal[0][];
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE}
        };
        BigDecimal[][] matrix2 = new BigDecimal[0][];
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_SingleElement() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(2)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(3)}
        };
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(6)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertTrue(java.util.Objects.deepEquals(expected, result.get()));
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
        BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.ONE, BigDecimal.ZERO}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertTrue(java.util.Objects.deepEquals(expected, result.get()));
    }

    @Test
    public void testMultiply_NegativeValues() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(-1), BigDecimal.valueOf(2)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(-4)}
        };
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(-11)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertTrue(java.util.Objects.deepEquals(expected, result.get()));
    }
}
// ```
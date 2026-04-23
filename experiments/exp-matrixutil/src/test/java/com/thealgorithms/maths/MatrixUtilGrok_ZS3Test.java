package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public class MatrixUtilGrok_ZS3Test {

    @Test
    void testMultiply_ValidMatrices() {
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
    void testMultiply_InvalidFirstMatrixNull() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_InvalidFirstMatrixEmpty() {
        BigDecimal[][] matrix1 = new BigDecimal[0][];
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_InvalidSecondMatrixNull() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_InvalidSecondMatrixEmpty() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = new BigDecimal[0][];
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_IncompatibleDimensions() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.valueOf(2)}, {BigDecimal.valueOf(3)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_SingleElementMatrices() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(3)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(4)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(12)}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    void testMultiply_RowVector() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}, {BigDecimal.valueOf(4)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(11)}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    void testMultiply_ColumnVector() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}, {BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3), BigDecimal.valueOf(4)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(3), BigDecimal.valueOf(4)}, {BigDecimal.valueOf(6), BigDecimal.valueOf(8)}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }

    @Test
    void testMultiply_WithZero() {
        BigDecimal[][] matrix1 = {{BigDecimal.ZERO, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ZERO}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.ZERO}};
        assertTrue(Arrays.deepEquals(expected, result.get()));
    }
}
// ```
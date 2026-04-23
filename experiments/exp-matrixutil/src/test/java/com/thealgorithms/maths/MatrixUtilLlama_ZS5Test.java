package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilLlama_ZS5Test {

    @Test
    public void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}};
        assertTrue(MatrixUtil.multiply(matrix1, matrix2).isEmpty());
    }

    @Test
    public void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        assertTrue(MatrixUtil.multiply(matrix1, matrix2).isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}};
        assertTrue(MatrixUtil.multiply(matrix1, matrix2).isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {};
        assertTrue(MatrixUtil.multiply(matrix1, matrix2).isEmpty());
    }

    @Test
    public void testMultiply_IncompatibleMatrixSizes() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        assertTrue(MatrixUtil.multiply(matrix1, matrix2).isEmpty());
    }

    @Test
    public void testMultiply_ValidMatrixMultiplication() {
        BigDecimal[][] matrix1 = {
            {new BigDecimal(1), new BigDecimal(2), new BigDecimal(3)},
            {new BigDecimal(4), new BigDecimal(5), new BigDecimal(6)},
            {new BigDecimal(7), new BigDecimal(8), new BigDecimal(9)},
        };

        BigDecimal[][] matrix2 = {
            {new BigDecimal(1), new BigDecimal(2)},
            {new BigDecimal(3), new BigDecimal(4)},
            {new BigDecimal(5), new BigDecimal(6)},
        };

        BigDecimal[][] expected = {
            {new BigDecimal(22), new BigDecimal(28)},
            {new BigDecimal(49), new BigDecimal(64)},
            {new BigDecimal(76), new BigDecimal(100)},
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected, result.get());
    }

    @Test
    public void testMultiply_ZeroMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.ZERO}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        BigDecimal[][] expected = {{BigDecimal.ZERO}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected, result.get());
    }

    @Test
    public void testMultiply_SingleElementMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.TEN}};
        BigDecimal[][] expected = {{BigDecimal.TEN}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected, result.get());
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixUtilLlama_ZS4Test {

    @Test
    public void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_IncompatibleMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_ValidMatrix() {
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
        assertEquals(expected.length, result.get().length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, result.get()[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], result.get()[i][j]);
            }
        }
    }

    @Test
    public void testMultiply_ZeroMatrix() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO},
        };

        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ONE},
            {BigDecimal.ONE, BigDecimal.ONE},
        };

        BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO},
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertEquals(expected.length, result.get().length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, result.get()[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], result.get()[i][j]);
            }
        }
    }
}
// ```
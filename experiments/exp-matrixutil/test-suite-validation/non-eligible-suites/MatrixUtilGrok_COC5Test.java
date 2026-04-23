package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;

public class MatrixUtilGrok_COC5Test {

    @Test
    public void testMultiply_InvalidDimensions() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ZERO}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ZERO}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_SingleIteration() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}, {BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3), BigDecimal.valueOf(4)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(3), BigDecimal.valueOf(4)}, {BigDecimal.valueOf(6), BigDecimal.valueOf(8)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    public void testMultiply_MultipleIterations() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.valueOf(2)}, {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(5), BigDecimal.valueOf(6)}, {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(19), BigDecimal.valueOf(22)}, {BigDecimal.valueOf(43), BigDecimal.valueOf(50)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    public void testMultiply_NormalCase() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)}, {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.valueOf(2)}, {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}, {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(22), BigDecimal.valueOf(28)}, {BigDecimal.valueOf(49), BigDecimal.valueOf(64)}};
        assertArrayEquals(expected, result.get());
    }
}
// ```
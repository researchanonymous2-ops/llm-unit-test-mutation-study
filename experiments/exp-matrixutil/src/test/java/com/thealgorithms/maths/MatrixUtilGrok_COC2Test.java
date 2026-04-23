package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilGrok_COC2Test {

    @Test
    void testMultiply_InvalidDimensions() {
        // P0: !canMultiply, return Optional.empty()
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.TEN}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    void testMultiply_SizeOne() {
        // P1: size == 1, single iteration in inner loop
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}, {BigDecimal.TEN}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(2)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(2)}, {BigDecimal.valueOf(20)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_SizeGreaterThanOne() {
        // P2: size > 1, multiple iterations in inner loop
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
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_ValidDimensions() {
        // P3: successful multiplication, return Optional.of(result)
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ZERO}};
        BigDecimal[][] matrix2 = {{BigDecimal.ZERO}, {BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.ZERO}};
        assertArrayEquals(expected, result.get());
    }
}
// ```
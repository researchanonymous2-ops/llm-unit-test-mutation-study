package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class MatrixUtilGrok_COC4Test {

    @Test
    void testMultiply_CannotMultiply_ReturnsEmpty() {
        // P0: !canMultiply(matrix1, matrix2) is true, return Optional.empty()
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ZERO}}; // 1x2
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ZERO}, {BigDecimal.ONE}}; // 3x1
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_SizeOne_SingleIteration_ReturnsProduct() {
        // P1: size == 1, single iteration in inner loop
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(2)}}; // 1x1
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}}; // 1x1
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(6)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_SizeGreaterThanOne_MultipleIterations_ReturnsProduct() {
        // P2: size > 1, multiple iterations in inner loop
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        }; // 2x2
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}
        }; // 2x2
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(19), BigDecimal.valueOf(22)},
            {BigDecimal.valueOf(43), BigDecimal.valueOf(50)}
        };
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_ValidMatrices_ReturnsProduct() {
        // P3: normal path, return Optional.of(result)
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        }; // 2x3
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)},
            {BigDecimal.valueOf(9), BigDecimal.TEN},
            {BigDecimal.valueOf(11), BigDecimal.valueOf(12)}
        }; // 3x2
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(58), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(139), BigDecimal.valueOf(154)}
        };
        assertArrayEquals(expected, result.get());
    }
}
// ```
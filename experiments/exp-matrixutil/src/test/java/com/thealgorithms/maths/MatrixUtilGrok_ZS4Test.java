package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class MatrixUtilGrok_ZS4Test {

    @Test
    void testMultiply_Valid2x2Matrices() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(19), BigDecimal.valueOf(22)},
            {BigDecimal.valueOf(43), BigDecimal.valueOf(50)}
        };
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_Valid3x3And3x2Matrices() {
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
    void testMultiply_InvalidMatrices_CannotMultiply() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_Valid1x1Matrices() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(5)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(15)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_WithZeros() {
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
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_WithNegatives() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(-1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(-4)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(5), BigDecimal.valueOf(-6)},
            {BigDecimal.valueOf(-7), BigDecimal.valueOf(8)}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(-19), BigDecimal.valueOf(22)},
            {BigDecimal.valueOf(43), BigDecimal.valueOf(-50)}
        };
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_Matrix1WithEmptyRow() {
        BigDecimal[][] matrix1 = { {} };
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_Matrix2WithEmptyRow() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = { {} };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilLlama_OS4Test {

    @Test
    void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_IncompatibleMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ONE}, {BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_ValidMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(1), BigDecimal.valueOf(2)}, {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(5), BigDecimal.valueOf(6)}, {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}};
        BigDecimal[][] expected = {{BigDecimal.valueOf(19), BigDecimal.valueOf(22)}, {BigDecimal.valueOf(43), BigDecimal.valueOf(50)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected[0], result.get()[0]);
        assertArrayEquals(expected[1], result.get()[1]);
    }

    @Test
    void testMultiply_SquareMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.ONE}, {BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] expected = {{BigDecimal.valueOf(2), BigDecimal.valueOf(2)}, {BigDecimal.valueOf(2), BigDecimal.valueOf(2)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected[0], result.get()[0]);
        assertArrayEquals(expected[1], result.get()[1]);
    }

    @Test
    void testMultiply_RectangularMatrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)}, {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(7), BigDecimal.valueOf(8)}, {BigDecimal.valueOf(9), BigDecimal.valueOf(10)}, {BigDecimal.valueOf(11), BigDecimal.valueOf(12)}};
        BigDecimal[][] expected = {{BigDecimal.valueOf(58), BigDecimal.valueOf(64)}, {BigDecimal.valueOf(139), BigDecimal.valueOf(154)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected[0], result.get()[0]);
        assertArrayEquals(expected[1], result.get()[1]);
    }
}
// ```
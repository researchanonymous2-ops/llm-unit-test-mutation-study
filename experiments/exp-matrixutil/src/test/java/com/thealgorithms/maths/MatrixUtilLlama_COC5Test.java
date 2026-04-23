package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixUtilLlama_COC5Test {

    @Test
    public void testMultiply_IncompatibleMatrices() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ONE}, {BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_Size1Matrix() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        BigDecimal[][] expected = {{BigDecimal.valueOf(6)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    public void testMultiply_MultipleIterations() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
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
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    public void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        BigDecimal[][] matrix2 = null;
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }
}
// ```
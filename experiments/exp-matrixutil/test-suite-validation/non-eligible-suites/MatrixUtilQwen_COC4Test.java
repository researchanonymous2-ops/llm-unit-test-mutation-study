package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;

public class MatrixUtilQwen_COC4Test {

    @Test
    void testMultiply_valid2x2And2x2Matrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(2), BigDecimal.valueOf(0)},
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(4), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(10), BigDecimal.valueOf(8)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_valid3x3And3x2Matrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleDimensions() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_singleElementMatrices() {
        final BigDecimal[][] matrix1 = {{BigDecimal.valueOf(5)}};
        final BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {{BigDecimal.valueOf(15)}};
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_firstMatrixNull() {
        final BigDecimal[][] matrix1 = null;
        final BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixNull() {
        final BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        final BigDecimal[][] matrix2 = null;
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptyFirstMatrix() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {{BigDecimal.ONE}};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptySecondMatrix() {
        final BigDecimal[][] matrix1 = {{BigDecimal.ONE}};
        final BigDecimal[][] matrix2 = {};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_zeroMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ZERO}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
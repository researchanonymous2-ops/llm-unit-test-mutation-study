package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;

public class MatrixUtilQwen_COC3Test {

    @Test
    void testMultiply_validSquareMatrices() {
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
    void testMultiply_validNonSquareMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)},
            {BigDecimal.valueOf(9), BigDecimal.valueOf(10)},
            {BigDecimal.valueOf(11), BigDecimal.valueOf(12)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(58), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(139), BigDecimal.valueOf(154)}
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
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixNull() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = null;
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_bothMatricesNull() {
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptyFirstMatrix() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_emptySecondMatrix() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = {};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_matricesWithZeroValues() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.valueOf(2), BigDecimal.ZERO}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.TEN}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        final BigDecimal[][] expected = {
            {BigDecimal.ZERO, BigDecimal.TEN},
            {BigDecimal.valueOf(2), BigDecimal.ZERO}
        };
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
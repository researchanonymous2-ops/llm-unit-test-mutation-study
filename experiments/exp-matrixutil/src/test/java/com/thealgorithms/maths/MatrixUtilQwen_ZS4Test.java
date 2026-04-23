package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilQwen_ZS4Test {

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
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(4), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(10), BigDecimal.valueOf(8)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
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
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(58), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(139), BigDecimal.valueOf(154)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_singleElementMatrices() {
        final BigDecimal[][] matrix1 = {{BigDecimal.valueOf(5)}};
        final BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        final BigDecimal[][] expected = {{BigDecimal.valueOf(15)}};
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleMatrices() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_firstMatrixNull() {
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixNull() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_bothMatricesNull() {
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_firstMatrixEmpty() {
        final BigDecimal[][] matrix1 = {};
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_secondMatrixEmpty() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        final BigDecimal[][] matrix2 = {};
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_matricesWithZeroValues() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ZERO, BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.ZERO}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ZERO, BigDecimal.ZERO},
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2)}
        };
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(2), BigDecimal.valueOf(4)},
            {BigDecimal.ZERO, BigDecimal.ZERO}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_negativeValues() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(-1), BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(3), BigDecimal.valueOf(-4)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(2), BigDecimal.valueOf(-3)},
            {BigDecimal.valueOf(-1), BigDecimal.valueOf(2)}
        };
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(-4), BigDecimal.valueOf(7)},
            {BigDecimal.valueOf(10), BigDecimal.valueOf(-17)}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilQwen_POT5Test {

    @Test
    void testMultiply_incompatibleDimensions_returnsEmpty() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN},
            {BigDecimal.ZERO, BigDecimal.ONE}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_validSingleElementMultiplication_returnsResult() {
        final BigDecimal[][] matrix1 = {{BigDecimal.valueOf(3)}};
        final BigDecimal[][] matrix2 = {{BigDecimal.valueOf(4)}};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        
        final BigDecimal[][] expected = {{BigDecimal.valueOf(12)}};
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_validFullIteration_returnsCorrectProduct() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
        };
        
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)},
            {BigDecimal.valueOf(9), BigDecimal.TEN},
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
}
// ```
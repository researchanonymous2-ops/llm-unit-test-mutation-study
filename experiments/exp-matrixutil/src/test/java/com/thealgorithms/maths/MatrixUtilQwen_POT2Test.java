package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilQwen_POT2Test {

    @Test
    void testMultiply_incompatibleDimensions_returnsEmpty() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.ONE},
            {BigDecimal.TEN},
            {BigDecimal.ZERO}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_singleElementMatrices_returnsProduct() {
        final BigDecimal[][] matrix1 = {{BigDecimal.valueOf(3)}};
        final BigDecimal[][] matrix2 = {{BigDecimal.valueOf(4)}};
        final BigDecimal[][] expected = {{BigDecimal.valueOf(12)}};
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_fullIteration_returnsCorrectProduct() {
        final BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN},
            {BigDecimal.valueOf(2), BigDecimal.valueOf(3)}
        };
        final BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5)},
            {BigDecimal.valueOf(6), BigDecimal.valueOf(7)}
        };
        final BigDecimal[][] expected = {
            {BigDecimal.valueOf(64), BigDecimal.valueOf(75)},
            {BigDecimal.valueOf(26), BigDecimal.valueOf(31)}
        };
        
        final Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
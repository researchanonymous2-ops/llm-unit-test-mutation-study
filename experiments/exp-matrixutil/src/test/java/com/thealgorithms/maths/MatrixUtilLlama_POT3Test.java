package com.thealgorithms.maths;

// ```java
import com.thealgorithms.maths.MatrixUtil;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixUtilLlama_POT3Test {

    @Test
    public void testMultiply_DimensionsIncompatible() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ONE}, {BigDecimal.ONE}};
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_SizeEqualsOne() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(6)}};
        assertEquals(expected[0][0], result.get()[0][0]);
    }

    @Test
    public void testMultiply_ValidMultiplication() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ONE},
            {BigDecimal.ONE, BigDecimal.ONE}
        };
        
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5)},
            {BigDecimal.valueOf(10), BigDecimal.valueOf(11)},
            {BigDecimal.valueOf(16), BigDecimal.valueOf(17)}
        };
        BigDecimal[][] actual = result.get();
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}
// ```
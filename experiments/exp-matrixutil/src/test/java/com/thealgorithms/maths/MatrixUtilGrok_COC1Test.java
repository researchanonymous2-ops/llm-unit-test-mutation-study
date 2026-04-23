package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_COC1Test {

    @Test
    public void testMultiply_InvalidDimensions() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ZERO}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ZERO}, {BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_SizeOne() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}, {BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3), BigDecimal.valueOf(4)}};
        Optional<BigDecimal[][]> resultOpt = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(resultOpt.isPresent());
        BigDecimal[][] result = resultOpt.get();
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(6), BigDecimal.valueOf(8)}
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultiply_SizeGreaterThanOne() {
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
        Optional<BigDecimal[][]> resultOpt = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(resultOpt.isPresent());
        BigDecimal[][] result = resultOpt.get();
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
            {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
        };
        assertArrayEquals(expected, result);
    }
}
// ```
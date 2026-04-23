package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;

public class MatrixUtilGrok_POT3Test {

    @Test
    void testMultiply_IncompatibleDimensions() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.TEN}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.TEN}, {BigDecimal.ZERO}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    void testMultiply_SizeOne() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE}, {BigDecimal.TEN}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE, BigDecimal.TEN}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.ONE, BigDecimal.TEN}, {BigDecimal.TEN, BigDecimal.valueOf(100)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    void testMultiply_FullIteration() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO},
            {BigDecimal.TEN, BigDecimal.ONE, BigDecimal.TEN},
            {BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.ONE}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.TEN},
            {BigDecimal.TEN, BigDecimal.ONE},
            {BigDecimal.ZERO, BigDecimal.TEN}
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(101), BigDecimal.valueOf(20)},
            {BigDecimal.valueOf(20), BigDecimal.valueOf(111)},
            {BigDecimal.valueOf(100), BigDecimal.valueOf(11)}
        };
        assertArrayEquals(expected, result.get());
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import com.thealgorithms.maths.MatrixUtil;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilLlama_POT1Test {

    @Test
    public void testMultiply_IncompatibleMatrices() {
        BigDecimal[][] matrix1 = {{BigDecimal.ONE, BigDecimal.ONE}};
        BigDecimal[][] matrix2 = {{BigDecimal.ONE}, {BigDecimal.ONE}, {BigDecimal.ONE}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_ValidMultiplication_Size1() {
        BigDecimal[][] matrix1 = {{BigDecimal.valueOf(2)}};
        BigDecimal[][] matrix2 = {{BigDecimal.valueOf(3)}};
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {{BigDecimal.valueOf(6)}};
        assertArrayEquals(expected, result.get());
    }

    @Test
    public void testMultiply_ValidMultiplication() {
        BigDecimal[][] matrix1 = {
            {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.valueOf(7), BigDecimal.valueOf(8)},
            {BigDecimal.valueOf(9), BigDecimal.valueOf(10)},
            {BigDecimal.valueOf(11), BigDecimal.valueOf(12)},
        };
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        BigDecimal[][] expected = {
            {BigDecimal.valueOf(58), BigDecimal.valueOf(64)},
            {BigDecimal.valueOf(139), BigDecimal.valueOf(154)},
        };
        assertArrayEquals(expected, result.get());
    }

    private void assertArrayEquals(BigDecimal[][] expected, BigDecimal[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    private void assertArrayEquals(BigDecimal[] expected, BigDecimal[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
// ```
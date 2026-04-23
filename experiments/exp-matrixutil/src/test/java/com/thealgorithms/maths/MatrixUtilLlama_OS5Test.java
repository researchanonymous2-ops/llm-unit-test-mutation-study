package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilLlama_OS5Test {

    @Test
    void testMultiply_ValidInput() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
            { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(7), BigDecimal.valueOf(8) },
            { BigDecimal.valueOf(9), BigDecimal.valueOf(10) },
            { BigDecimal.valueOf(11), BigDecimal.valueOf(12) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
    }

    @Test
    void testMultiply_IncompatibleMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(5), BigDecimal.valueOf(6), BigDecimal.valueOf(7) },
            { BigDecimal.valueOf(8), BigDecimal.valueOf(9), BigDecimal.valueOf(10) },
            { BigDecimal.valueOf(11), BigDecimal.valueOf(12), BigDecimal.valueOf(13) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_NullMatrix1() {
        BigDecimal[][] matrix1 = null;
        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_NullMatrix2() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
        };
        BigDecimal[][] matrix2 = null;

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyMatrix1() {
        BigDecimal[][] matrix1 = {};
        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyMatrix2() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
        };
        BigDecimal[][] matrix2 = {};

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_Result() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
            { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) },
            { BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) },
            { BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
        };

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(22), BigDecimal.valueOf(28) },
            { BigDecimal.valueOf(49), BigDecimal.valueOf(64) },
            { BigDecimal.valueOf(76), BigDecimal.valueOf(100) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
        assertArrayEquals(expected, result.get());
    }
}
// ```
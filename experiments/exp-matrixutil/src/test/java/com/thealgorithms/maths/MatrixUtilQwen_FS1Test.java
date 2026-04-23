package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilQwen_FS1Test {

    @Test
    void testMultiply_ValidMatrices_ReturnsResult() {
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
    void testMultiply_IncompatibleDimensions_ReturnsEmpty() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE },
            { BigDecimal.ONE },
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_SingleElementMatrices_ReturnsResult() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.TEN }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(5) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
    }

    @Test
    void testMultiply_FirstMatrixNull_ReturnsEmpty() {
        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_SecondMatrixNull_ReturnsEmpty() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_BothMatricesNull_ReturnsEmpty() {
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptyFirstMatrix_ReturnsEmpty() {
        BigDecimal[][] matrix1 = {};

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptySecondMatrix_ReturnsEmpty() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {};

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_ValidSquareMatrices_ReturnsResult() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) },
            { BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
    }

    @Test
    void testMultiply_NonSquareCompatibleMatrices_ReturnsResult() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3) },
            { BigDecimal.valueOf(4) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());
    }
}
// ```
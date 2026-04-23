package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilQwen_FS2Test {

    @Test
    void testMultiply_ValidMatrices_ReturnsCorrectResult() {
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

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(58), BigDecimal.valueOf(64) },
            { BigDecimal.valueOf(139), BigDecimal.valueOf(154) }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_IncompatibleMatrices_ReturnsEmpty() {
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
    void testMultiply_SingleElementMatrices_ReturnsCorrectResult() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.TEN }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(5) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(50) }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_IdentityMatrix_ReturnsOtherMatrix() {
        BigDecimal[][] identity = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix = {
            { BigDecimal.valueOf(3), BigDecimal.valueOf(7) },
            { BigDecimal.valueOf(2), BigDecimal.valueOf(4) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(identity, matrix);
        assertTrue(result.isPresent());

        MatrixUtil.assertThat(result.get(), matrix);
    }

    @Test
    void testMultiply_ZeroMatrix_ReturnsZeroMatrix() {
        BigDecimal[][] zeroMatrix = {
            { BigDecimal.ZERO, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ZERO }
        };

        BigDecimal[][] matrix = {
            { BigDecimal.ONE, BigDecimal.TEN },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(7) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(zeroMatrix, matrix);
        assertTrue(result.isPresent());

        BigDecimal[][] expected = {
            { BigDecimal.ZERO, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ZERO }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_NonSquareMatrices_ReturnsCorrectResult() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(4) },
            { BigDecimal.valueOf(5) },
            { BigDecimal.valueOf(6) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(32) }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_FirstMatrixNull_ReturnsEmpty() {
        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_SecondMatrixNull_ReturnsEmpty() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
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
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_EmptySecondMatrix_ReturnsEmpty() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {};

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }
}
// ```
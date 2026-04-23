package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilQwen_FS5Test {

    @Test
    void testMultiply_validSquareMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
            { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(2), BigDecimal.valueOf(0) },
            { BigDecimal.valueOf(1), BigDecimal.valueOf(2) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(4), BigDecimal.valueOf(4) },
            { BigDecimal.valueOf(10), BigDecimal.valueOf(8) }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_incompatibleMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE },
            { BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_singleElementMatrices() {
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
    void testMultiply_rectangularMatrices() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE },
            { BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
            { BigDecimal.valueOf(4), BigDecimal.valueOf(5) },
            { BigDecimal.valueOf(6), BigDecimal.valueOf(7) }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());

        BigDecimal[][] expected = {
            { BigDecimal.valueOf(8), BigDecimal.valueOf(10) },
            { BigDecimal.valueOf(4), BigDecimal.valueOf(5) }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }

    @Test
    void testMultiply_firstMatrixWithZeroRows() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ONE },
            { BigDecimal.ONE, BigDecimal.ONE },
            { BigDecimal.ONE, BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertFalse(result.isPresent());
    }

    @Test
    void testMultiply_resultMatrixWithZeroValues() {
        BigDecimal[][] matrix1 = {
            { BigDecimal.ONE, BigDecimal.ONE },
            { BigDecimal.ONE, BigDecimal.ONE }
        };

        BigDecimal[][] matrix2 = {
            { BigDecimal.ONE, BigDecimal.ONE.negate() },
            { BigDecimal.ONE.negate(), BigDecimal.ONE }
        };

        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
        assertTrue(result.isPresent());

        BigDecimal[][] expected = {
            { BigDecimal.ZERO, BigDecimal.ZERO },
            { BigDecimal.ZERO, BigDecimal.ZERO }
        };

        MatrixUtil.assertThat(result.get(), expected);
    }
}
// ```
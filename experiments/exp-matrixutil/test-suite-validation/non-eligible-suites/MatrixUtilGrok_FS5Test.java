package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_FS5Test {

   @Test
   void testMultiply_Compatible2x2Matrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_IncompatibleMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE },
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_1x1Matrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(2) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(3) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(6) }
       };
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_2x3And3x2Matrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3), BigDecimal.valueOf(4) },
           { BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(22), BigDecimal.valueOf(28) },
           { BigDecimal.valueOf(49), BigDecimal.valueOf(64) }
       };
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_WithZeros() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ZERO }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ZERO }
       };
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_WithNegativeValues() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(-1), BigDecimal.valueOf(2) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(-4) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(-11) }
       };
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_NullMatrix1() {
       BigDecimal[][] matrix1 = null;
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_EmptyMatrix1() {
       BigDecimal[][] matrix1 = {};
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_3x1And1x3Matrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE },
           { BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) },
           { BigDecimal.valueOf(8), BigDecimal.valueOf(10), BigDecimal.valueOf(12) },
           { BigDecimal.valueOf(12), BigDecimal.valueOf(15), BigDecimal.valueOf(18) }
       };
       assertArrayEquals(expected, result.get());
   }
}

package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_FS4Test {

   @Test
   void testMultiply_CompatibleMatrices_ResultPresent() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3), BigDecimal.ZERO }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.valueOf(4) },
           { BigDecimal.valueOf(5), BigDecimal.ZERO }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
   }

   @Test
   void testMultiply_IncompatibleDimensions_ResultEmpty() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE },
           { BigDecimal.valueOf(3) },
           { BigDecimal.ZERO }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_NullMatrix1_ResultEmpty() {
       BigDecimal[][] matrix1 = null;

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_NullMatrix2_ResultEmpty() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = null;

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_EmptyMatrix1_ResultEmpty() {
       BigDecimal[][] matrix1 = {};

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_EmptyMatrix2_ResultEmpty() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {};

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_SingleElementMatrices_ResultCorrect() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(7) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(8) }
       };

       BigDecimal[][] expected = {
           { BigDecimal.valueOf(56) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_ZeroMatrices_ResultZero() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ZERO, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ZERO }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3), BigDecimal.ZERO }
       };

       BigDecimal[][] expected = {
           { BigDecimal.ZERO, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ZERO }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       assertArrayEquals(expected, result.get());
   }

   @Test
   void testMultiply_LargerMatrices_ResultCorrect() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3), BigDecimal.ZERO },
           { BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
       };

       BigDecimal[][] expected = {
           { BigDecimal.valueOf(22), BigDecimal.valueOf(20) },
           { BigDecimal.valueOf(49), BigDecimal.valueOf(44) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       assertArrayEquals(expected, result.get());
   }
}

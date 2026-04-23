package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_OS2Test {

   @Test
   void testMultiply_Valid2x2Matrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3), BigDecimal.valueOf(4) }
       };
       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(5), BigDecimal.valueOf(6) },
           { BigDecimal.valueOf(7), BigDecimal.valueOf(8) }
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(19), BigDecimal.valueOf(22) },
           { BigDecimal.valueOf(43), BigDecimal.valueOf(50) }
       };
       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_IncompatibleMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ONE },
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
   void testMultiply_NullMatrix1() {
       BigDecimal[][] matrix1 = null;
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_NullMatrix2() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };
       BigDecimal[][] matrix2 = null;
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_EmptyMatrix1() {
       BigDecimal[][] matrix1 = new BigDecimal[0][0];
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_EmptyMatrix2() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };
       BigDecimal[][] matrix2 = new BigDecimal[0][0];
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_SingleElementMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(3) }
       };
       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(4) }
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(12) }
       };
       assertTrue(Arrays.deepEquals(expected, result.get()));
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
       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithNegatives() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(-1), BigDecimal.ONE }
       };
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE },
           { BigDecimal.valueOf(-1) }
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(-2) }
       };
       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_LargerMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) }
       };
       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(7), BigDecimal.valueOf(8) },
           { BigDecimal.valueOf(9), BigDecimal.TEN },
           { BigDecimal.valueOf(11), BigDecimal.valueOf(12) }
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           { BigDecimal.valueOf(58), BigDecimal.valueOf(64) },
           { BigDecimal.valueOf(139), BigDecimal.valueOf(154) }
       };
       assertTrue(Arrays.deepEquals(expected, result.get()));
   }
}

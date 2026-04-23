package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_FS1Test {

   @Test
   void testMultiply_CompatibleSquareMatrices() {
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

       assertArrayEquals(expected, result.get(), (a, b) -> Arrays.deepEquals(a, b) ? 0 : 1);
   }

   @Test
   void testMultiply_IncompatibleDimensions() {
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

       assertArrayEquals(expected, result.get(), (a, b) -> Arrays.deepEquals(a, b) ? 0 : 1);
   }

   @Test
   void testMultiply_NonSquareCompatibleMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE },
           { BigDecimal.ZERO },
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.valueOf(2) }
       };

       assertArrayEquals(expected, result.get(), (a, b) -> Arrays.deepEquals(a, b) ? 0 : 1);
   }

   @Test
   void testMultiply_WithNullMatrix1() {
       BigDecimal[][] matrix1 = null;

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_WithEmptyMatrix1() {
       BigDecimal[][] matrix1 = new BigDecimal[0][];

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_WithZeroColumnsMatrix1() {
       BigDecimal[][] matrix1 = {
           {}
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_WithNullMatrix2() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = null;

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_WithBothMatricesInvalid() {
       BigDecimal[][] matrix1 = null;
       BigDecimal[][] matrix2 = null;

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_LargerMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(2) }
       };

       assertArrayEquals(expected, result.get(), (a, b) -> Arrays.deepEquals(a, b) ? 0 : 1);
   }
}

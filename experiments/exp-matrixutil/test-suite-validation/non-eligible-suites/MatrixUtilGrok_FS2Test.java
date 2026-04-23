package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_FS2Test {

   @Test
   void testMultiply_WithCompatibleMatrices() {
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

       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithIncompatibleDimensions() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_WithSingleElementMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.ONE }
       };

       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithLargerMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6) },
           { BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9) }
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
           { BigDecimal.valueOf(49), BigDecimal.valueOf(64) },
           { BigDecimal.valueOf(76), BigDecimal.valueOf(100) }
       };

       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithZeroMatrices() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ZERO, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ZERO }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.ZERO, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ZERO }
       };

       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithDifferentCompatibleSizes() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.valueOf(2) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE },
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.valueOf(3) }
       };

       assertTrue(Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithNullMatrix() {
       BigDecimal[][] matrix1 = null;
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_WithEmptyMatrix() {
       BigDecimal[][] matrix1 = new BigDecimal[0][];
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }
}

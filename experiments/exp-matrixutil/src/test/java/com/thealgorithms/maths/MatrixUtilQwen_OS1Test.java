package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilQwen_OS1Test {

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
   void testMultiply_validNonSquareMatrices() {
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
   void testMultiply_singleElementMatrices() {
       BigDecimal[][] matrix1 = { { BigDecimal.valueOf(5) } };
       BigDecimal[][] matrix2 = { { BigDecimal.valueOf(3) } };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = { { BigDecimal.valueOf(15) } };

       MatrixUtil.assertThat(result.get(), expected);
   }

   @Test
   void testMultiply_incompatibleDimensions() {
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
   void testMultiply_firstMatrixNull() {
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_secondMatrixNull() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, null);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_bothMatricesNull() {
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_emptyMatrices() {
       BigDecimal[][] matrix1 = { {} };
       BigDecimal[][] matrix2 = { {} };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_matrixWithZeroes() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.valueOf(2), BigDecimal.ZERO }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ZERO, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.valueOf(3) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.ZERO, BigDecimal.valueOf(3) },
           { BigDecimal.ZERO, BigDecimal.ZERO }
       };

       MatrixUtil.assertThat(result.get(), expected);
   }
}

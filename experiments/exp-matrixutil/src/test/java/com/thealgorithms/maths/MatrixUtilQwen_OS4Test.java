package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilQwen_OS4Test {

   @Test
   void testMultiply_validMatrices_expectCorrectResult() {
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
   void testMultiply_incompatibleMatrices_expectEmpty() {
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
   void testMultiply_firstMatrixNull_expectEmpty() {
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_secondMatrixNull_expectEmpty() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, null);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_bothMatricesNull_expectEmpty() {
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_singleElementMatrices_expectCorrectResult() {
       BigDecimal[][] matrix1 = { { BigDecimal.valueOf(5) } };
       BigDecimal[][] matrix2 = { { BigDecimal.valueOf(6) } };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = { { BigDecimal.valueOf(30) } };
       MatrixUtil.assertThat(result.get(), expected);
   }

   @Test
   void testMultiply_negativeValues_expectCorrectResult() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(-1), BigDecimal.valueOf(2) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(-4) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = { { BigDecimal.valueOf(-11) } };
       MatrixUtil.assertThat(result.get(), expected);
   }

   @Test
   void testMultiply_zeroValues_expectCorrectResult() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ZERO, BigDecimal.ONE },
           { BigDecimal.ONE, BigDecimal.ZERO }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ZERO, BigDecimal.ZERO },
           { BigDecimal.ONE, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.ONE, BigDecimal.ONE },
           { BigDecimal.ZERO, BigDecimal.ZERO }
       };

       MatrixUtil.assertThat(result.get(), expected);
   }

   @Test
   void testMultiply_emptyMatrices_expectEmpty() {
       BigDecimal[][] matrix1 = { {} };
       BigDecimal[][] matrix2 = { {} };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_largeValues_expectCorrectResult() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(1000), BigDecimal.valueOf(2000) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(3000) },
           { BigDecimal.valueOf(4000) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = { { BigDecimal.valueOf(11000000) } };
       MatrixUtil.assertThat(result.get(), expected);
   }
}

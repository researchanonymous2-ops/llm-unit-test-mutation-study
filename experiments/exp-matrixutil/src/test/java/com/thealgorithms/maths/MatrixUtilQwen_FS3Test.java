package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilQwen_FS3Test {

   @Test
   void testMultiply_validSquareMatrices_returnsCorrectResult() {
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
   void testMultiply_incompatibleMatrices_returnsEmpty() {
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
   void testMultiply_singleElementMatrices_returnsProduct() {
       BigDecimal[][] matrix1 = { { BigDecimal.TEN } };
       BigDecimal[][] matrix2 = { { BigDecimal.valueOf(5) } };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = { { BigDecimal.valueOf(50) } };
       MatrixUtil.assertThat(result.get(), expected);
   }

   @Test
   void testMultiply_rectangularMatrices_returnsCorrectResult() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.TEN, BigDecimal.valueOf(2) },
           { BigDecimal.valueOf(3), BigDecimal.valueOf(4), BigDecimal.valueOf(5) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.valueOf(2), BigDecimal.valueOf(3) },
           { BigDecimal.valueOf(4), BigDecimal.valueOf(5) },
           { BigDecimal.valueOf(6), BigDecimal.valueOf(7) }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       BigDecimal[][] expected = {
           { BigDecimal.valueOf(54), BigDecimal.valueOf(67) },
           { BigDecimal.valueOf(52), BigDecimal.valueOf(64) }
       };

       MatrixUtil.assertThat(result.get(), expected);
   }

   @Test
   void testMultiply_firstMatrixNull_returnsEmpty() {
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_secondMatrixNull_returnsEmpty() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, null);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_bothMatricesNull_returnsEmpty() {
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(null, null);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_emptyFirstMatrix_returnsEmpty() {
       BigDecimal[][] matrix1 = {};
       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_emptySecondMatrix_returnsEmpty() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.ONE }
       };
       BigDecimal[][] matrix2 = {};

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_identityMatrix_returnsSameAsFirstMatrix() {
       BigDecimal[][] matrix1 = {
           { BigDecimal.valueOf(5), BigDecimal.valueOf(7) },
           { BigDecimal.valueOf(2), BigDecimal.valueOf(3) }
       };

       BigDecimal[][] matrix2 = {
           { BigDecimal.ONE, BigDecimal.ZERO },
           { BigDecimal.ZERO, BigDecimal.ONE }
       };

       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());

       MatrixUtil.assertThat(result.get(), matrix1);
   }
}

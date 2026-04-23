package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_OS1Test {

   @Test
   void testMultiply_Valid2x2() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ONE, BigDecimal.valueOf(2)},
           {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
           {BigDecimal.valueOf(7), BigDecimal.valueOf(8)}
       };
       BigDecimal[][] expected = {
           {BigDecimal.valueOf(19), BigDecimal.valueOf(22)},
           {BigDecimal.valueOf(43), BigDecimal.valueOf(50)}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       assertTrue(java.util.Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_IncompatibleMatrices() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ONE, BigDecimal.ONE},
           {BigDecimal.ONE, BigDecimal.ONE}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.ONE},
           {BigDecimal.ONE}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_NullMatrix1() {
       BigDecimal[][] matrix1 = null;
       BigDecimal[][] matrix2 = {
           {BigDecimal.ONE}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_NullMatrix2() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ONE}
       };
       BigDecimal[][] matrix2 = null;
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertFalse(result.isPresent());
   }

   @Test
   void testMultiply_1x1() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.valueOf(2)}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.valueOf(3)}
       };
       BigDecimal[][] expected = {
           {BigDecimal.valueOf(6)}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       assertTrue(java.util.Arrays.deepEquals(expected, result.get()));
   }

   @Test
   void testMultiply_WithZeros() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ZERO, BigDecimal.ONE},
           {BigDecimal.ONE, BigDecimal.ZERO}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.ONE, BigDecimal.ZERO},
           {BigDecimal.ZERO, BigDecimal.ONE}
       };
       BigDecimal[][] expected = {
           {BigDecimal.ZERO, BigDecimal.ONE},
           {BigDecimal.ONE, BigDecimal.ZERO}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       assertTrue(java.util.Arrays.deepEquals(expected, result.get()));
   }
}

package com.thealgorithms.maths;

package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;

public class MatrixUtilGrok_POT4Test {

   @Test
   public void testMultiply_IncompatibleDimensions() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ONE, BigDecimal.ZERO},
           {BigDecimal.ZERO, BigDecimal.ONE}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.ONE},
           {BigDecimal.ZERO}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isEmpty());
   }

   @Test
   public void testMultiply_SizeOne() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ONE},
           {BigDecimal.valueOf(2)}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.ONE, BigDecimal.ZERO}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           {BigDecimal.ONE, BigDecimal.ZERO},
           {BigDecimal.valueOf(2), BigDecimal.ZERO}
       };
       assertArrayEquals(expected, result.get());
   }

   @Test
   public void testMultiply_FullIteration() {
       BigDecimal[][] matrix1 = {
           {BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
           {BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
           {BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9)}
       };
       BigDecimal[][] matrix2 = {
           {BigDecimal.ONE, BigDecimal.valueOf(2)},
           {BigDecimal.valueOf(3), BigDecimal.valueOf(4)},
           {BigDecimal.valueOf(5), BigDecimal.valueOf(6)}
       };
       Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);
       assertTrue(result.isPresent());
       BigDecimal[][] expected = {
           {BigDecimal.valueOf(22), BigDecimal.valueOf(28)},
           {BigDecimal.valueOf(49), BigDecimal.valueOf(64)},
           {BigDecimal.valueOf(76), BigDecimal.valueOf(100)}
       };
       assertArrayEquals(expected, result.get());
   }
}

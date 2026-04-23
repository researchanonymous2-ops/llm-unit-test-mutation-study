package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionQwen_OS4Test {

   @Test
   void testGetReducedFraction_positiveReducible() {
       Fraction result = Fraction.getReducedFraction(6, 9);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_negativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-4, 10);
       assertEquals(-2, result.getNumerator());
       assertEquals(5, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_negativeDenominator() {
       Fraction result = Fraction.getReducedFraction(3, -7);
       assertEquals(-3, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_bothNegative() {
       Fraction result = Fraction.getReducedFraction(-8, -12);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_zeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertEquals(0, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_zeroDenominator() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(3, 0);
       });
   }

   @Test
   void testGetReducedFraction_alreadyInLowestTerms() {
       Fraction result = Fraction.getReducedFraction(7, 3);
       assertEquals(7, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_denominatorOne() {
       Fraction result = Fraction.getReducedFraction(11, 1);
       assertEquals(11, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_minValueNumerator() {
       Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, 2);
       assertEquals(Integer.MIN_VALUE / 2, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_minValueDenominator() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(1, Integer.MIN_VALUE);
       });
   }

   @Test
   void testGetReducedFraction_minValueBoth() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
       });
   }

   @Test
   void testGetReducedFraction_maxValueNumerator() {
       Fraction result = Fraction.getReducedFraction(Integer.MAX_VALUE, 4);
       assertEquals(Integer.MAX_VALUE / 4, result.getNumerator());
       assertEquals(4, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_maxValueDenominator() {
       Fraction result = Fraction.getReducedFraction(3, Integer.MAX_VALUE);
       assertEquals(3, result.getNumerator());
       assertEquals(Integer.MAX_VALUE, result.getDenominator());
   }
}

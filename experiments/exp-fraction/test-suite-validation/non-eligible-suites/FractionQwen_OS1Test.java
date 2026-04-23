package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionQwen_OS1Test {

   @Test
   void testGetReducedFraction_positiveReduced() {
       Fraction result = Fraction.getReducedFraction(3, 9);
       assertEquals(1, result.getNumerator());
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
       Fraction result = Fraction.getReducedFraction(6, -15);
       assertEquals(-2, result.getNumerator());
       assertEquals(5, result.getDenominator());
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
   void testGetReducedFraction_unitDenominator() {
       Fraction result = Fraction.getReducedFraction(7, 1);
       assertEquals(7, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_sameValue() {
       Fraction result = Fraction.getReducedFraction(5, 5);
       assertEquals(1, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_denominatorZero() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(3, 0);
       });
   }

   @Test
   void testGetReducedFraction_minValueNumerator() {
       Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, 2);
       assertEquals(Integer.MIN_VALUE / 2, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_minValueDenominator() {
       Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
       assertEquals(-2, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_minValueBoth() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
       });
   }

   @Test
   void testGetReducedFraction_coprimeValues() {
       Fraction result = Fraction.getReducedFraction(17, 19);
       assertEquals(17, result.getNumerator());
       assertEquals(19, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_largeCommonDivisor() {
       Fraction result = Fraction.getReducedFraction(42, 56);
       assertEquals(3, result.getNumerator());
       assertEquals(4, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_negativeWithMinValueDenominator() {
       Fraction result = Fraction.getReducedFraction(-2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
   }
}

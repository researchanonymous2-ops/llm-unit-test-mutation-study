package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_FS3Test {

   @Test
   void testGetReducedFraction_PositiveNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(4, 8);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(-5, 10);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_PositiveNumeratorNegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(7, -14);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeNumeratorNegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(-9, -12);
       assertEquals(3, result.getNumerator());
       assertEquals(4, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_ZeroDenominatorThrowsException() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(2, 0));
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(3, 7);
       assertEquals(3, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_LargeNumbers() {
       Fraction result = Fraction.getReducedFraction(100, 200);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_IntegerMinValueHandling() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_OverflowCase() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }
}

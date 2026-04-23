package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_FS5Test {

   @Test
   void testGetReducedFractionPositiveNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(4, 8);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFractionAlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(5, 7);
       assertEquals(new Fraction(5, 7), result);
   }

   @Test
   void testGetReducedFractionZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 9);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFractionNegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-6, 10);
       assertEquals(new Fraction(-3, 5), result);
   }

   @Test
   void testGetReducedFractionNegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(7, -14);
       assertEquals(new Fraction(-1, 2), result);
   }

   @Test
   void testGetReducedFractionBothNegative() {
       Fraction result = Fraction.getReducedFraction(-8, -12);
       assertEquals(new Fraction(2, 3), result);
   }

   @Test
   void testGetReducedFractionZeroDenominatorThrowsException() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(2, 0));
   }

   @Test
   void testGetReducedFractionLargeNumbers() {
       Fraction result = Fraction.getReducedFraction(100, 200);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFractionOneAsDenominator() {
       Fraction result = Fraction.getReducedFraction(9, 1);
       assertEquals(new Fraction(9, 1), result);
   }

   @Test
   void testGetReducedFractionPrimeNumbers() {
       Fraction result = Fraction.getReducedFraction(13, 17);
       assertEquals(new Fraction(13, 17), result);
   }
}

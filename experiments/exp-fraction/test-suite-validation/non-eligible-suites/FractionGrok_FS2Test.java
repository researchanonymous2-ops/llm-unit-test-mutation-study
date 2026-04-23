package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_FS2Test {

   @Test
   void testGetReducedFraction_ReduceFraction() {
       Fraction result = Fraction.getReducedFraction(8, 12);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_ZeroDenominator() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(2, 0));
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(3, -4);
       assertEquals(-3, result.getNumerator());
       assertEquals(4, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-6, 8);
       assertEquals(-3, result.getNumerator());
       assertEquals(4, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(5, 7);
       assertEquals(5, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_MinValueHandling() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_Overflow() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }
}

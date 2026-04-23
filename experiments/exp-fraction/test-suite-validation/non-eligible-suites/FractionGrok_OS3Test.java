package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionGrok_OS3Test {

   @Test
   void testGetReducedFraction_PositiveReduced() {
       Fraction result = Fraction.getReducedFraction(2, 4);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(1, 2);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_NegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-2, 4);
       assertEquals(new Fraction(-1, 2), result);
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(2, -4);
       assertEquals(new Fraction(-1, 2), result);
   }

   @Test
   void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-2, -4);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_DenominatorOne() {
       Fraction result = Fraction.getReducedFraction(5, 1);
       assertEquals(new Fraction(5, 1), result);
   }

   @Test
   void testGetReducedFraction_LargeGcd() {
       Fraction result = Fraction.getReducedFraction(3, 6);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_DenominatorZero() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   void testGetReducedFraction_IntegerMinValueDenominatorEvenNumerator() {
       Fraction result = Fraction.getReducedFraction(-2, Integer.MIN_VALUE);
       assertEquals(new Fraction(1, Integer.MIN_VALUE / 2), result);
   }

   @Test
   void testGetReducedFraction_IntegerMinValueNumerator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }

   @Test
   void testGetReducedFraction_IntegerMinValueDenominator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }
}

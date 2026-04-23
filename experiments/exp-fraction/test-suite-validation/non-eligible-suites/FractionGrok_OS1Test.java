package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_OS1Test {

   @Test
   void testGetReducedFraction_PositiveFraction() {
       Fraction result = Fraction.getReducedFraction(2, 4);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(3, 5);
       assertEquals(new Fraction(3, 5), result);
   }

   @Test
   void testGetReducedFraction_NumeratorZero() {
       Fraction result = Fraction.getReducedFraction(0, 7);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(1, -2);
       assertEquals(new Fraction(-1, 2), result);
   }

   @Test
   void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-3, -6);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_Reduction() {
       Fraction result = Fraction.getReducedFraction(4, 6);
       assertEquals(new Fraction(2, 3), result);
   }

   @Test
   void testGetReducedFraction_DenominatorOne() {
       Fraction result = Fraction.getReducedFraction(5, 1);
       assertEquals(new Fraction(5, 1), result);
   }

   @Test
   void testGetReducedFraction_NegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-2, 4);
       assertEquals(new Fraction(-1, 2), result);
   }

   @Test
   void testGetReducedFraction_LargeNumbers() {
       Fraction result = Fraction.getReducedFraction(100, 200);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_DenominatorZero() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   void testGetReducedFraction_IntegerMinValue() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(new Fraction(1, Integer.MIN_VALUE / 2), result);
   }
}

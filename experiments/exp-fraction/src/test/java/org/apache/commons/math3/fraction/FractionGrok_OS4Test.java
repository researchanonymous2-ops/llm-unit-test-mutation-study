package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_OS4Test {

   @Test
   void testGetReducedFraction_NormalReduction() {
       Fraction result = Fraction.getReducedFraction(6, 9);
       assertEquals(new Fraction(2, 3), result);
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(3, 5);
       assertEquals(new Fraction(3, 5), result);
   }

   @Test
   void testGetReducedFraction_NegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-4, 6);
       assertEquals(new Fraction(-2, 3), result);
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(4, -6);
       assertEquals(new Fraction(-2, 3), result);
   }

   @Test
   void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-4, -6);
       assertEquals(new Fraction(2, 3), result);
   }

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 7);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_DenominatorZero() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   void testGetReducedFraction_LargeNumbers() {
       Fraction result = Fraction.getReducedFraction(100, 200);
       assertEquals(new Fraction(1, 2), result);
   }

   @Test
   void testGetReducedFraction_OneAsDenominator() {
       Fraction result = Fraction.getReducedFraction(5, 1);
       assertEquals(new Fraction(5, 1), result);
   }

   @Test
   void testGetReducedFraction_EqualNumeratorDenominator() {
       Fraction result = Fraction.getReducedFraction(7, 7);
       assertEquals(new Fraction(1, 1), result);
   }
}

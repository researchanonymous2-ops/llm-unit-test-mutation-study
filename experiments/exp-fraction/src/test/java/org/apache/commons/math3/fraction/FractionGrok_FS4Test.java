package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_FS4Test {

   @Test
   void testGetReducedFraction_PositiveNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(4, 8);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(5, 7);
       assertEquals(5, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 9);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(2, -6);
       assertEquals(-1, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-8, -12);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_LargeGcd() {
       Fraction result = Fraction.getReducedFraction(15, 25);
       assertEquals(3, result.getNumerator());
       assertEquals(5, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_DenominatorZeroThrowsException() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(5, 0));
   }

   @Test
   void testGetReducedFraction_NegativeNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(-10, 20);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_OneAsDenominator() {
       Fraction result = Fraction.getReducedFraction(7, 1);
       assertEquals(7, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_MinValueHandling() {
       Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, 2);
       assertEquals(-1073741824, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }
}

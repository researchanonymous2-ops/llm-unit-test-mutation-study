package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionQwen_FS2Test {

   @Test
   void testGetReducedFraction_ValidPositiveFraction() {
       Fraction result = Fraction.getReducedFraction(6, 9);
       assertNotNull(result);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-4, 10);
       assertNotNull(result);
       assertEquals(-2, result.getNumerator());
       assertEquals(5, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertNotNull(result);
       assertEquals(0, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_ZeroDenominator_ThrowsException() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(3, 0));
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(3, -7);
       assertNotNull(result);
       assertEquals(-3, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-8, -12);
       assertNotNull(result);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_AlreadyInLowestTerms() {
       Fraction result = Fraction.getReducedFraction(5, 7);
       assertNotNull(result);
       assertEquals(5, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_MinValueDenominator() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertNotNull(result);
       assertEquals(-1, result.getNumerator());
       assertEquals(Integer.MAX_VALUE, result.getDenominator());
   }
}

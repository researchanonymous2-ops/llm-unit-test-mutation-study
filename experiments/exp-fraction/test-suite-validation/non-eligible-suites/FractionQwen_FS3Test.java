package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionQwen_FS3Test {

   @Test
   void testGetReducedFraction_validPositiveInputs() {
       Fraction result = Fraction.getReducedFraction(6, 9);
       assertNotNull(result);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_negativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-4, 10);
       assertNotNull(result);
       assertEquals(-2, result.getNumerator());
       assertEquals(5, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_negativeDenominator() {
       Fraction result = Fraction.getReducedFraction(3, -7);
       assertNotNull(result);
       assertEquals(-3, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_bothNegative() {
       Fraction result = Fraction.getReducedFraction(-8, -12);
       assertNotNull(result);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_zeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertNotNull(result);
       assertEquals(0, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_zeroDenominatorThrowsException() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(3, 0));
   }

   @Test
   void testGetReducedFraction_minValueNumeratorAndDenominator() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
   }

   @Test
   void testGetReducedFraction_minValueNumerator() {
       Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, 2);
       assertNotNull(result);
       assertEquals(Integer.MIN_VALUE / 2, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_minValueDenominator() {
       assertThrows(MathArithmeticException.class,
           () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   void testGetReducedFraction_alreadyReducedFraction() {
       Fraction result = Fraction.getReducedFraction(7, 3);
       assertNotNull(result);
       assertEquals(7, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_denominatorOne() {
       Fraction result = Fraction.getReducedFraction(11, 1);
       assertNotNull(result);
       assertEquals(11, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_numeratorAndDenominatorEqual() {
       Fraction result = Fraction.getReducedFraction(13, 13);
       assertNotNull(result);
       assertEquals(1, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }
}

package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionQwen_OS3Test {

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
   void testGetReducedFraction_alreadyReduced() {
       Fraction result = Fraction.getReducedFraction(5, 7);
       assertEquals(5, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_minValueNumerator() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(Integer.MIN_VALUE, -1);
       });
   }

   @Test
   void testGetReducedFraction_minValueDenominator() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(-1, Integer.MIN_VALUE);
       });
   }

   @Test
   void testGetReducedFraction_zeroDenominator() {
       assertThrows(MathArithmeticException.class, () -> {
           Fraction.getReducedFraction(3, 0);
       });
   }

   @Test
   void testGetReducedFraction_minValueSpecialCase() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(-1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_largeValues() {
       Fraction result = Fraction.getReducedFraction(123456, 789012);
       assertEquals(10288, result.getNumerator());
       assertEquals(65751, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_sameValue() {
       Fraction result = Fraction.getReducedFraction(10, 10);
       assertEquals(1, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }
}

package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionGrok_ZS1Test {

   @Test
   public void testGetReducedFraction_PositiveNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(4, 6);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_NegativeNumeratorPositiveDenominator() {
       Fraction result = Fraction.getReducedFraction(-4, 6);
       assertEquals(-2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_PositiveNumeratorNegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(4, -6);
       assertEquals(-2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_NegativeNumeratorNegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(-4, -6);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   public void testGetReducedFraction_DenominatorZero() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   public void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(2, 3);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_LargeGcd() {
       Fraction result = Fraction.getReducedFraction(100, 200);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominatorEvenNumerator() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominatorOddNumerator() {
       Fraction result = Fraction.getReducedFraction(1, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueNumeratorNegativeDenominator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   public void testGetReducedFraction_OneAsDenominator() {
       Fraction result = Fraction.getReducedFraction(5, 1);
       assertEquals(5, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_NegativeOneAsDenominator() {
       Fraction result = Fraction.getReducedFraction(5, -1);
       assertEquals(-5, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }
}

package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_ZS2Test {

   @Test
   public void testGetReducedFraction_ZeroNumerator() {
       assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, 5));
   }

   @Test
   public void testGetReducedFraction_ZeroDenominator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   public void testGetReducedFraction_PositiveReduced() {
       Fraction result = Fraction.getReducedFraction(2, 4);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(1, -2);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-1, -2);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(3, 5);
       assertEquals(3, result.getNumerator());
       assertEquals(5, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_LargeGcd() {
       Fraction result = Fraction.getReducedFraction(6, 9);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominatorEvenNumerator() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominatorOddNumerator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueNumeratorNegativeDenominator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominatorNegative() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   public void testGetReducedFraction_MaxValues() {
       Fraction result = Fraction.getReducedFraction(Integer.MAX_VALUE, Integer.MAX_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }
}

package org.apache.commons.math3.fraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_COC4Test {

   @Test
   public void testGetReducedFraction_DenominatorZero() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   public void testGetReducedFraction_NumeratorZero() {
       assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, 5));
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueEven() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(Integer.MIN_VALUE / 2, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_IntegerMinValueDenominatorOddNumerator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   public void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(1, -2);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_NegativeDenominatorMinValueNumerator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }

   @Test
   public void testGetReducedFraction_NormalReduction() {
       Fraction result = Fraction.getReducedFraction(4, 6);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(3, 7);
       assertEquals(3, result.getNumerator());
       assertEquals(7, result.getDenominator());
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
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   public void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-4, -6);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }
}

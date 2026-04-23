package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_ZS4Test {

   @Test
   void testGetReducedFraction_ZeroNumerator() {
       Fraction result = Fraction.getReducedFraction(0, 5);
       assertEquals(Fraction.ZERO, result);
   }

   @Test
   void testGetReducedFraction_ZeroDenominator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   void testGetReducedFraction_PositiveReduction() {
       Fraction result = Fraction.getReducedFraction(4, 6);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeNumerator() {
       Fraction result = Fraction.getReducedFraction(-4, 6);
       assertEquals(-2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(4, -6);
       assertEquals(-2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_BothNegative() {
       Fraction result = Fraction.getReducedFraction(-4, -6);
       assertEquals(2, result.getNumerator());
       assertEquals(3, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_AlreadyReduced() {
       Fraction result = Fraction.getReducedFraction(3, 5);
       assertEquals(3, result.getNumerator());
       assertEquals(5, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_IntegerMinValueDenominatorEven() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_IntegerMinValueDenominatorOdd() {
       Fraction result = Fraction.getReducedFraction(1, Integer.MIN_VALUE);
       assertEquals(-1, result.getNumerator());
       assertEquals(1073741824, result.getDenominator()); // Integer.MIN_VALUE negated and divided by gcd=1
   }

   @Test
   void testGetReducedFraction_IntegerMinValueNumeratorNegativeDenom() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
   }

   @Test
   void testGetReducedFraction_IntegerMinValueDenom() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   void testGetReducedFraction_One() {
       Fraction result = Fraction.getReducedFraction(5, 5);
       assertEquals(1, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_NegativeOne() {
       Fraction result = Fraction.getReducedFraction(-5, 5);
       assertEquals(-1, result.getNumerator());
       assertEquals(1, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_LargeNumbers() {
       Fraction result = Fraction.getReducedFraction(100, 200);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }
}

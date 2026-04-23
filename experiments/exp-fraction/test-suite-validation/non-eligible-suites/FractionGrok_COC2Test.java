package org.apache.commons.math3.fraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_COC2Test {

   @Test
   void testGetReducedFraction_DenominatorZero() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
   }

   @Test
   void testGetReducedFraction_NumeratorZero() {
       assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, 1));
       assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, -1));
   }

   @Test
   void testGetReducedFraction_SpecialMinValueEvenNumerator() {
       Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
       assertEquals(1, result.getNumerator());
       assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_SpecialMinValueOddNumerator() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   void testGetReducedFraction_NegativeDenominator() {
       Fraction result = Fraction.getReducedFraction(1, -2);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());
   }

   @Test
   void testGetReducedFraction_OverflowInNegation() {
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
       assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
   }

   @Test
   void testGetReducedFraction_NormalReduction() {
       Fraction result = Fraction.getReducedFraction(2, 4);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());

       result = Fraction.getReducedFraction(3, 6);
       assertEquals(1, result.getNumerator());
       assertEquals(2, result.getDenominator());

       result = Fraction.getReducedFraction(-2, 4);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());

       result = Fraction.getReducedFraction(2, -4);
       assertEquals(-1, result.getNumerator());
       assertEquals(2, result.getDenominator());

       result = Fraction.getReducedFraction(5, 7);
       assertEquals(5, result.getNumerator());
       assertEquals(7, result.getDenominator());
   }
}

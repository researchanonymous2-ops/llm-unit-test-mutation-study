package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionGrok_POT1Test {

    @Test
    void testGetReducedFraction_ZeroDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_SpecialCaseMinValue() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        // After normalization: numerator=1, denominator=Integer.MIN_VALUE/2
        // Then gcd and reduce: should be 1 / (Integer.MIN_VALUE/2)
        assertEquals(1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_ReducedFraction() {
        Fraction result = Fraction.getReducedFraction(4, 6);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }
}
// ```
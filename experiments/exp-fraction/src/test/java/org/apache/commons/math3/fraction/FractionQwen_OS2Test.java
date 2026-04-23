package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionQwen_OS2Test {

    @Test
    void testGetReducedFraction_positiveReducible() {
        Fraction result = Fraction.getReducedFraction(6, 9);
        assertEquals(2, result.getNumerator());
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
        Fraction result = Fraction.getReducedFraction(3, -7);
        assertEquals(-3, result.getNumerator());
        assertEquals(7, result.getDenominator());
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
    void testGetReducedFraction_zeroDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(3, 0);
        });
    }

    @Test
    void testGetReducedFraction_alreadyInLowestTerms() {
        Fraction result = Fraction.getReducedFraction(5, 7);
        assertEquals(5, result.getNumerator());
        assertEquals(7, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_denominatorOne() {
        Fraction result = Fraction.getReducedFraction(11, 1);
        assertEquals(11, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_minValueSpecialCase() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(-1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_overflowMinValueNumerator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, -1);
        });
    }

    @Test
    void testGetReducedFraction_overflowMinValueDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(-1, Integer.MIN_VALUE);
        });
    }
}
// ```
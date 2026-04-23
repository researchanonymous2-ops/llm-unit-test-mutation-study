package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionQwen_OS5Test {

    @Test
    void testGetReducedFraction_positiveReducible() {
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
    void testGetReducedFraction_unitFraction() {
        Fraction result = Fraction.getReducedFraction(1, 1);
        assertNotNull(result);
        assertEquals(1, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_alreadyInLowestTerms() {
        Fraction result = Fraction.getReducedFraction(5, 7);
        assertNotNull(result);
        assertEquals(5, result.getNumerator());
        assertEquals(7, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_denominatorOne() {
        Fraction result = Fraction.getReducedFraction(11, 1);
        assertNotNull(result);
        assertEquals(11, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_minValueSpecialCase() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertNotNull(result);
        assertEquals(-1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_zeroDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(3, 0);
        });
    }

    @Test
    void testGetReducedFraction_overflowFromNegation() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
    }
}
// ```
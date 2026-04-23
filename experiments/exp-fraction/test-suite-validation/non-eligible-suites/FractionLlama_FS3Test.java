package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionLlama_FS3Test {

    @Test
    void testGetReducedFraction_ValidInput() {
        Fraction result = Fraction.getReducedFraction(3, 6);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(1, -3);
        assertEquals(new Fraction(-1, 3), result);
    }

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 3);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_ZeroDenominatorThrowsException() {
        assertThrows(MathArithmeticException.class,
            () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    void testGetReducedFraction_MinValueDenominator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(new Fraction(1, Integer.MIN_VALUE / 2), result);
    }

    @Test
    void testGetReducedFraction_MinValueNumeratorAndDenominatorThrowsException() {
        assertThrows(MathArithmeticException.class,
            () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void testGetReducedFraction_MinValueNumeratorAndPositiveDenominatorThrowsException() {
        assertThrows(MathArithmeticException.class,
            () -> Fraction.getReducedFraction(Integer.MIN_VALUE, 1));
    }

    @Test
    void testGetReducedFraction_NormalizeNegativeFraction() {
        Fraction result = Fraction.getReducedFraction(-1, -3);
        assertEquals(new Fraction(1, 3), result);
    }

    @Test
    void testGetReducedFraction_GCDSimplification() {
        Fraction result = Fraction.getReducedFraction(4, 8);
        assertEquals(new Fraction(1, 2), result);
    }
}
// ```
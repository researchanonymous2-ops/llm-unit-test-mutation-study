package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionGrok_OS5Test {

    @Test
    void testGetReducedFraction_PositiveReduced() {
        Fraction result = Fraction.getReducedFraction(4, 8);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    void testGetReducedFraction_NegativeNumerator() {
        Fraction result = Fraction.getReducedFraction(-3, 6);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -6);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    void testGetReducedFraction_BothNegative() {
        Fraction result = Fraction.getReducedFraction(-3, -6);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    void testGetReducedFraction_AlreadyReduced() {
        Fraction result = Fraction.getReducedFraction(1, 3);
        assertEquals(new Fraction(1, 3), result);
    }

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 7);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_DenominatorZero() {
        assertThrows(org.apache.commons.math3.exception.MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
    }

    @Test
    void testGetReducedFraction_LargeNumbers() {
        Fraction result = Fraction.getReducedFraction(100, 200);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    void testGetReducedFraction_One() {
        Fraction result = Fraction.getReducedFraction(5, 5);
        assertEquals(Fraction.ONE, result);
    }

    @Test
    void testGetReducedFraction_NegativeOne() {
        Fraction result = Fraction.getReducedFraction(-5, 5);
        assertEquals(Fraction.MINUS_ONE, result);
    }
}
// ```
package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_ZS1Test {

    @Test
    void testGetReducedFraction_positiveFraction() {
        Fraction f = Fraction.getReducedFraction(6, 8);
        assertEquals(3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_negativeNumerator() {
        Fraction f = Fraction.getReducedFraction(-6, 8);
        assertEquals(-3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_negativeDenominator() {
        Fraction f = Fraction.getReducedFraction(6, -8);
        assertEquals(-3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_bothNegative() {
        Fraction f = Fraction.getReducedFraction(-6, -8);
        assertEquals(3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_zeroNumerator() {
        Fraction f = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, f);
    }

    @Test
    void testGetReducedFraction_unitDenominator() {
        Fraction f = Fraction.getReducedFraction(7, 1);
        assertEquals(7, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_alreadyReduced() {
        Fraction f = Fraction.getReducedFraction(3, 7);
        assertEquals(3, f.getNumerator());
        assertEquals(7, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_denominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(5, 0));
    }

    @Test
    void testGetReducedFraction_minValueNumerator() {
        Fraction f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2);
        assertEquals(Integer.MIN_VALUE / 2, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testGetReducedFraction_minValueDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
    }

    @Test
    void testGetReducedFraction_minValueBoth() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void testGetReducedFraction_powerOfTwoOverMinValue() {
        Fraction f = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, f.getNumerator());
        assertEquals(Integer.MAX_VALUE, f.getDenominator());
    }
}
// ```
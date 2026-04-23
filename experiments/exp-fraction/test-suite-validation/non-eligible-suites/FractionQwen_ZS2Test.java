package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_ZS2Test {

    @Test
    public void testGetReducedFraction_zeroNumerator() {
        Fraction f = Fraction.getReducedFraction(0, 5);
        assertEquals(0, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_positiveReducible() {
        Fraction f = Fraction.getReducedFraction(6, 9);
        assertEquals(2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_positiveIrreducible() {
        Fraction f = Fraction.getReducedFraction(3, 7);
        assertEquals(3, f.getNumerator());
        assertEquals(7, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeNumerator() {
        Fraction f = Fraction.getReducedFraction(-4, 6);
        assertEquals(-2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeDenominator() {
        Fraction f = Fraction.getReducedFraction(4, -6);
        assertEquals(-2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_bothNegative() {
        Fraction f = Fraction.getReducedFraction(-4, -6);
        assertEquals(2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_denominatorOne() {
        Fraction f = Fraction.getReducedFraction(5, 1);
        assertEquals(5, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_numeratorOne() {
        Fraction f = Fraction.getReducedFraction(1, 5);
        assertEquals(1, f.getNumerator());
        assertEquals(5, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_minValueDenominatorAndEvenNumerator() {
        Fraction f = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, f.getNumerator());
        assertEquals(Integer.MIN_VALUE / -2, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_minValueDenominatorAndOddNumerator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(3, Integer.MIN_VALUE);
        });
    }

    @Test
    public void testGetReducedFraction_minValueNumeratorAndDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
    }

    @Test
    public void testGetReducedFraction_zeroDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(5, 0);
        });
    }

    @Test
    public void testGetReducedFraction_sameValueDifferentSigns() {
        Fraction f1 = Fraction.getReducedFraction(-6, 9);
        Fraction f2 = Fraction.getReducedFraction(6, -9);
        assertEquals(f1.getNumerator(), f2.getNumerator());
        assertEquals(f1.getDenominator(), f2.getDenominator());
    }

    @Test
    public void testGetReducedFraction_alreadyReduced() {
        Fraction f = Fraction.getReducedFraction(1, 1);
        assertEquals(1, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }
}
// ```
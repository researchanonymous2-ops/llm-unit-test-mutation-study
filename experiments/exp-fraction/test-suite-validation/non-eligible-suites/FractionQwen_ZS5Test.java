package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_ZS5Test {

    @Test
    public void testGetReducedFraction_zeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(0, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_positiveReducible() {
        Fraction result = Fraction.getReducedFraction(6, 9);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_positiveIrreducible() {
        Fraction result = Fraction.getReducedFraction(3, 5);
        assertEquals(3, result.getNumerator());
        assertEquals(5, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeNumerator() {
        Fraction result = Fraction.getReducedFraction(-4, 6);
        assertEquals(-2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeDenominator() {
        Fraction result = Fraction.getReducedFraction(4, -6);
        assertEquals(-2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_bothNegative() {
        Fraction result = Fraction.getReducedFraction(-4, -6);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_denominatorOne() {
        Fraction result = Fraction.getReducedFraction(7, 1);
        assertEquals(7, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_numeratorOne() {
        Fraction result = Fraction.getReducedFraction(1, 4);
        assertEquals(1, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_minValueDenominatorAndEvenNumerator() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
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
    public void testGetReducedFraction_alreadyReduced() {
        Fraction result = Fraction.getReducedFraction(1, 1);
        assertEquals(1, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_largeNumbers() {
        Fraction result = Fraction.getReducedFraction(1000000, 2000000);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }
}
// ```
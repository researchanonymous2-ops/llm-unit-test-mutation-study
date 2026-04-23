package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_ZS3Test {

    @Test
    public void testGetReducedFraction_zeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_positiveReduced() {
        Fraction result = Fraction.getReducedFraction(3, 4);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_positiveNotReduced() {
        Fraction result = Fraction.getReducedFraction(6, 8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeNumerator() {
        Fraction result = Fraction.getReducedFraction(-3, 4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_bothNegative() {
        Fraction result = Fraction.getReducedFraction(-3, -4);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeNumeratorDenominatorReduced() {
        Fraction result = Fraction.getReducedFraction(-6, 8);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_minValueNumerator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, -1);
        });
    }

    @Test
    public void testGetReducedFraction_minValueDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, Integer.MIN_VALUE);
        });
    }

    @Test
    public void testGetReducedFraction_minValueBoth() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
    }

    @Test
    public void testGetReducedFraction_minValueDenominatorEvenNumerator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(-1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_zeroDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(3, 0);
        });
    }

    @Test
    public void testGetReducedFraction_wholeNumber() {
        Fraction result = Fraction.getReducedFraction(5, 1);
        assertEquals(5, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_denominatorOne() {
        Fraction result = Fraction.getReducedFraction(7, 1);
        assertEquals(7, result.getNumerator());
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
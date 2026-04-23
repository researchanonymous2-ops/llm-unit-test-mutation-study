package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_COC1Test {

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
    }

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_DenominatorMinValueEvenNumerator() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, result.getNumerator());
        assertEquals(Integer.MAX_VALUE, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_DenominatorMinValueOddNumerator() {
        Fraction result = Fraction.getReducedFraction(3, Integer.MIN_VALUE);
        assertEquals(-3, result.getNumerator());
        assertEquals(Integer.MAX_VALUE, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeNumeratorAndDenominator() {
        Fraction result = Fraction.getReducedFraction(-6, -8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_PositiveNumeratorAndDenominator() {
        Fraction result = Fraction.getReducedFraction(6, 8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_AlreadyReduced() {
        Fraction result = Fraction.getReducedFraction(3, 7);
        assertEquals(3, result.getNumerator());
        assertEquals(7, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_BothNegative() {
        Fraction result = Fraction.getReducedFraction(-15, -25);
        assertEquals(3, result.getNumerator());
        assertEquals(5, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeNumerator() {
        Fraction result = Fraction.getReducedFraction(-12, 18);
        assertEquals(-2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }
}
// ```
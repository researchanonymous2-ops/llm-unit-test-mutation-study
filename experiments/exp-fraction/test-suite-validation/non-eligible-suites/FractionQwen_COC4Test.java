package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_COC4Test {

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
        assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_DenominatorMinValueOddNumerator() {
        Fraction result = Fraction.getReducedFraction(3, Integer.MIN_VALUE);
        assertEquals(3, result.getNumerator());
        assertEquals(Integer.MIN_VALUE, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeNumeratorPositiveDenominator() {
        Fraction result = Fraction.getReducedFraction(-6, 8);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_BothNegative() {
        Fraction result = Fraction.getReducedFraction(-6, -8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_ReducedForm() {
        Fraction result = Fraction.getReducedFraction(6, 8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_AlreadyInLowestTerms() {
        Fraction result = Fraction.getReducedFraction(3, 7);
        assertEquals(3, result.getNumerator());
        assertEquals(7, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NumeratorMinValueDenominatorMinValue() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
    }
}
// ```
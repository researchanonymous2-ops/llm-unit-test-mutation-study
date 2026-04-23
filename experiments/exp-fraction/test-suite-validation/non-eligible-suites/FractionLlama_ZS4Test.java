package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionLlama_ZS4Test {

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        Fraction fraction = Fraction.getReducedFraction(0, 10);
        assertEquals(Fraction.ZERO, fraction);
    }

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(10, 0));
    }

    @Test
    public void testGetReducedFraction_NumeratorAndDenominatorPositive() {
        Fraction fraction = Fraction.getReducedFraction(4, 8);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NumeratorNegativeDenominatorPositive() {
        Fraction fraction = Fraction.getReducedFraction(-4, 8);
        assertEquals(-1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NumeratorPositiveDenominatorNegative() {
        Fraction fraction = Fraction.getReducedFraction(4, -8);
        assertEquals(-1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NumeratorAndDenominatorNegative() {
        Fraction fraction = Fraction.getReducedFraction(-4, -8);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_MinValueDenominator() {
        Fraction fraction = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(-1, fraction.getNumerator());
        assertEquals(Integer.MAX_VALUE / 2 + 1, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_Overflow() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
// ```
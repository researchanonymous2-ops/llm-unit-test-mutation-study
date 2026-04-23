package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

public class FractionGrok_COC1Test {

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, 5));
    }

    @Test
    public void testGetReducedFraction_IntegerMinValueEvenNumerator() {
        assertEquals(new Fraction(-1, 1073741824), Fraction.getReducedFraction(2, Integer.MIN_VALUE));
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        assertEquals(new Fraction(-3, 4), Fraction.getReducedFraction(3, -4));
    }

    @Test
    public void testGetReducedFraction_PositiveReduced() {
        assertEquals(new Fraction(2, 3), Fraction.getReducedFraction(4, 6));
    }
}
// ```
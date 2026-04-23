package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionLlama_FS2Test {

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(Fraction.ZERO, result);
    }

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
    void testGetReducedFraction_ZeroDenominatorThrowsException() {
        assertThrows(MathArithmeticException.class,
            () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    void testGetReducedFraction_MinValueDenominator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(new Fraction(-1, -(Integer.MIN_VALUE / 2)), result);
    }

    @Test
    void testGetReducedFraction_Overflow() {
        assertThrows(MathArithmeticException.class,
            () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
// ```
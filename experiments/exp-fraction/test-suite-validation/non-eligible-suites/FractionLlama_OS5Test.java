package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;

public class FractionLlama_OS5Test {

    @Test
    void testGetReducedFraction_NormalCase() {
        Fraction result = Fraction.getReducedFraction(2, 4);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 4);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_DenominatorIsZero() {
        assertThrows(org.apache.commons.math3.exception.MathArithmeticException.class, 
                     () -> Fraction.getReducedFraction(2, 0));
    }

    @Test
    void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(2, -4);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    void testGetReducedFraction_MinValueDenominator() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(new Fraction(-2, Integer.MIN_VALUE / 2), result);
    }

    @Test
    void testGetReducedFraction_MinValueNumerator() {
        Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, 4);
        assertEquals(new Fraction(Integer.MIN_VALUE / 4, 1), result);
    }

    @Test
    void testGetReducedFraction_BothMinValue() {
        assertThrows(org.apache.commons.math3.exception.MathArithmeticException.class, 
                     () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
// ```
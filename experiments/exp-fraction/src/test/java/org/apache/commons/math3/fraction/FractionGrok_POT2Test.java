package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_POT2Test {

    @Test
    void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    void testGetReducedFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_SpecialCaseMinValue() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(new Fraction(1, Integer.MIN_VALUE / 2), result);
    }

    @Test
    void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(new Fraction(-3, 4), result);
    }

    @Test
    void testGetReducedFraction_ReducedFraction() {
        Fraction result = Fraction.getReducedFraction(4, 6);
        assertEquals(new Fraction(2, 3), result);
    }
}
// ```
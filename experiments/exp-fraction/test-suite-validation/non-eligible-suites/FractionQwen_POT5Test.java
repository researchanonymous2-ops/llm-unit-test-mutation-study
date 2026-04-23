package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_POT5Test {

    @Test
    void testGetReducedFraction_denominatorZero() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
    }

    @Test
    void testGetReducedFraction_numeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_specialCaseMinValue() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(-1, result.getNumerator());
        assertEquals(Integer.MAX_VALUE, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_negativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_normalReduction() {
        Fraction result = Fraction.getReducedFraction(6, 9);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }
}
// ```
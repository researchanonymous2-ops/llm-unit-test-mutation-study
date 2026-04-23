package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_POT2Test {

    @Test
    public void testGetReducedFraction_denominatorZero() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
    }

    @Test
    public void testGetReducedFraction_numeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_specialCaseMinValueDenominator() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, result.getNumerator());
        assertEquals(Integer.MAX_VALUE, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_normalCase() {
        Fraction result = Fraction.getReducedFraction(6, 8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }
}
// ```
package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_POT5Test {

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_SpecialCaseMinValueEvenNumerator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        // After normalization: numerator=1, denominator=Integer.MIN_VALUE/2
        // Then gcd(1, Integer.MIN_VALUE/2) = 1, so result is 1 / (Integer.MIN_VALUE/2)
        assertEquals(1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_ReducedFraction() {
        Fraction result = Fraction.getReducedFraction(4, 6);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }
}
// ```
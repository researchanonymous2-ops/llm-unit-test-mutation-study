package org.apache.commons.math3.fraction;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_COC5Test {

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
    public void testGetReducedFraction_IntegerMinValueDenominatorEvenNumerator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(1, -2);
        assertEquals(-1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NormalReduction() {
        Fraction result = Fraction.getReducedFraction(4, 6);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_IntegerMinValueNumeratorNegativeDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
    }

    @Test
    public void testGetReducedFraction_IntegerMinValueDenominatorNegativeDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
    }
}
// ```
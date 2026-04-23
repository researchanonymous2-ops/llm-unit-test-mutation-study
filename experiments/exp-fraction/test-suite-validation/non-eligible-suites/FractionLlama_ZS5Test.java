package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionLlama_ZS5Test {

    @Test
    public void testGetReducedFraction_NormalCase() {
        Fraction result = Fraction.getReducedFraction(4, 8);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 8);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_DenominatorIsZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(4, 0));
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(4, -8);
        assertEquals(-1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_MinValueDenominator() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, result.getNumerator());
        assertEquals(-1073741824, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_MinValueNumeratorAndDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -Integer.MIN_VALUE));
    }

    @Test
    public void testGetReducedFraction_Overflow() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
// ```
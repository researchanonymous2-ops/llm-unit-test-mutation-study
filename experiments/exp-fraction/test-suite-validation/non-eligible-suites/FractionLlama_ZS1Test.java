package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionLlama_ZS1Test {

    @Test
    public void testGetReducedFraction_NormalCase() {
        Fraction fraction = Fraction.getReducedFraction(6, 8);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_ZeroNumerator() {
        Fraction fraction = Fraction.getReducedFraction(0, 8);
        assertEquals(0, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_DenominatorIsZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(6, 0));
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction fraction = Fraction.getReducedFraction(6, -8);
        assertEquals(-3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_MinValueDenominator() {
        Fraction fraction = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, fraction.getNumerator());
        assertEquals(Integer.MAX_VALUE + 1, fraction.getDenominator());
    }

    @Test
    public void testGetReducedFraction_MinValueNumeratorAndDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -Integer.MIN_VALUE));
    }

    @Test
    public void testGetReducedFraction_AlreadyReduced() {
        Fraction fraction = Fraction.getReducedFraction(3, 4);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }
}
// ```
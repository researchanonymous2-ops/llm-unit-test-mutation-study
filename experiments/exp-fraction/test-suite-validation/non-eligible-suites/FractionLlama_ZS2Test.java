package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionLlama_ZS2Test {

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 1);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_MinValueDenominator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(new Fraction(1, Integer.MIN_VALUE / 2), result);
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(1, -1);
        assertEquals(Fraction.ONE.negate(), result);
    }

    @Test
    public void testGetReducedFraction_Overflow() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void testGetReducedFraction_Reduce() {
        Fraction result = Fraction.getReducedFraction(2, 4);
        assertEquals(Fraction.ONE_HALF, result);
    }

    @Test
    public void testGetReducedFraction_NoReduce() {
        Fraction result = Fraction.getReducedFraction(1, 2);
        assertEquals(Fraction.ONE_HALF, result);
    }

    @Test
    public void testGetReducedFraction_AlreadyReduced() {
        Fraction result = Fraction.getReducedFraction(1, 3);
        assertEquals(new Fraction(1, 3), result);
    }
}
// ```
package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionLlama_ZS3Test {

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
        assertEquals(new Fraction(-1, 1), result);
    }

    @Test
    public void testGetReducedFraction_MinValueNumeratorAndDenominator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
    }

    @Test
    public void testGetReducedFraction_ReduceFraction() {
        Fraction result = Fraction.getReducedFraction(2, 4);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testGetReducedFraction_NoReduction() {
        Fraction result = Fraction.getReducedFraction(1, 2);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testGetReducedFraction_AlreadyReduced() {
        Fraction result = Fraction.getReducedFraction(3, 5);
        assertEquals(new Fraction(3, 5), result);
    }
}
// ```
package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionLlama_COC1Test {

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
    public void testGetReducedFraction_SpecialCase() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(new Fraction(1, Integer.MIN_VALUE / 2), result);
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(1, -2);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    public void testGetReducedFraction_ReducedFraction() {
        Fraction result = Fraction.getReducedFraction(2, 4);
        assertEquals(new Fraction(1, 2), result);
    }
}
// ```
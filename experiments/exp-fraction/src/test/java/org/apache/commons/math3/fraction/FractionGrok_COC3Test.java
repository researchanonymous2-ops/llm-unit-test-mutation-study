package org.apache.commons.math3.fraction;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_COC3Test {

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, 5));
    }

    @Test
    public void testGetReducedFraction_SpecialMinValue() {
        assertEquals(new Fraction(-1, 1073741824), Fraction.getReducedFraction(2, Integer.MIN_VALUE));
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        assertEquals(new Fraction(-1, 2), Fraction.getReducedFraction(1, -2));
    }

    @Test
    public void testGetReducedFraction_PositiveReduce() {
        assertEquals(new Fraction(2, 3), Fraction.getReducedFraction(4, 6));
    }

    @Test
    public void testGetReducedFraction_Overflow() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
    }
}
// ```
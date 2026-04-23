package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionLlama_COC3Test {

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
    public void testGetReducedFraction_DenominatorMinValueAndNumeratorEven() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(new Fraction(2, Integer.MIN_VALUE / 2), result);
    }

    @Test
    public void testGetReducedFraction_DenominatorNegative() {
        Fraction result = Fraction.getReducedFraction(1, -2);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    public void testGetReducedFraction_NumeratorAndDenominatorPositive() {
        Fraction result = Fraction.getReducedFraction(2, 4);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testGetReducedFraction_NumeratorNegativeAndDenominatorPositive() {
        Fraction result = Fraction.getReducedFraction(-2, 4);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    public void testGetReducedFraction_NumeratorPositiveAndDenominatorNegative() {
        Fraction result = Fraction.getReducedFraction(2, -4);
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    public void testGetReducedFraction_NumeratorNegativeAndDenominatorNegative() {
        Fraction result = Fraction.getReducedFraction(-2, -4);
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testGetReducedFraction_NumeratorMinValueAndDenominatorNegative() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
    }

    @Test
    public void testGetReducedFraction_DenominatorMinValueAndNumeratorOdd() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(3, Integer.MIN_VALUE));
    }
}
// ```
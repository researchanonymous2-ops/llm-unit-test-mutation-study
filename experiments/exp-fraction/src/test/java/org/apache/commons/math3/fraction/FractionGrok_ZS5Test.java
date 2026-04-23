package org.apache.commons.math3.fraction;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class FractionGrok_ZS5Test {

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_ReducePositive() {
        Fraction result = Fraction.getReducedFraction(4, 6);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_ReduceNegativeNumerator() {
        Fraction result = Fraction.getReducedFraction(-4, 6);
        assertEquals(-2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_ReduceNegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(4, -6);
        assertEquals(-2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_BothNegative() {
        Fraction result = Fraction.getReducedFraction(-4, -6);
        assertEquals(2, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, 0));
    }

    @Test
    void testGetReducedFraction_IntegerMinValueDenominatorEven() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(-1, result.getNumerator());
        assertEquals(1073741824, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_IntegerMinValueDenominatorOdd() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(1, Integer.MIN_VALUE));
    }

    @Test
    void testGetReducedFraction_IntegerMinValueNumerator() {
        assertThrows(MathArithmeticException.class, () -> Fraction.getReducedFraction(Integer.MIN_VALUE, -1));
    }

    @Test
    void testGetReducedFraction_AlreadyReduced() {
        Fraction result = Fraction.getReducedFraction(7, 3);
        assertEquals(7, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_ReduceToOne() {
        Fraction result = Fraction.getReducedFraction(5, 5);
        assertEquals(1, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }
}
// ```
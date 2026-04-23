package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_ZS4Test {

    @Test
    public void testGetReducedFraction_positiveCommonDivisor() {
        Fraction f = Fraction.getReducedFraction(6, 9);
        assertEquals(2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeNumerator() {
        Fraction f = Fraction.getReducedFraction(-6, 9);
        assertEquals(-2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_negativeDenominator() {
        Fraction f = Fraction.getReducedFraction(6, -9);
        assertEquals(-2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_bothNegative() {
        Fraction f = Fraction.getReducedFraction(-6, -9);
        assertEquals(2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_zeroNumerator() {
        Fraction f = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, f);
    }

    @Test
    public void testGetReducedFraction_zeroDenominator() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(5, 0);
        });
    }

    @Test
    public void testGetReducedFraction_alreadyInLowestTerms() {
        Fraction f = Fraction.getReducedFraction(7, 3);
        assertEquals(7, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_denominatorOne() {
        Fraction f = Fraction.getReducedFraction(8, 1);
        assertEquals(8, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_numeratorOne() {
        Fraction f = Fraction.getReducedFraction(1, 5);
        assertEquals(1, f.getNumerator());
        assertEquals(5, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_minValueSpecialCaseValid() {
        Fraction f = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(-1, f.getNumerator());
        assertEquals(Integer.MAX_VALUE, f.getDenominator());
    }

    @Test
    public void testGetReducedFraction_minValueSpecialCaseInvalidNum() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, -1);
        });
    }

    @Test
    public void testGetReducedFraction_minValueSpecialCaseInvalidDen() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(-1, Integer.MIN_VALUE);
        });
    }
}
// ```
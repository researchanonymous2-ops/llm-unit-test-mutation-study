package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionQwen_COC2Test {

    @Test
    public void testGetReducedFraction_DenominatorZero() {
        assertThrows(MathArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
    }

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_DenominatorMinValueAndNumeratorEven() {
        Fraction result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
        assertEquals(-2, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / -2, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_DenominatorNegative() {
        Fraction result = Fraction.getReducedFraction(3, -4);
        assertEquals(-3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    public void testGetReducedFraction_NormalCase() {
        Fraction result = Fraction.getReducedFraction(6, 8);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }
}
// ```
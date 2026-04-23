package org.apache.commons.math3.fraction;

// ```java
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionLlama_POT1Test {

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
        assertEquals(new Fraction(-2, Integer.MAX_VALUE + 1), result);
    }

    @Test
    public void testGetReducedFraction_DenominatorNegative() {
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
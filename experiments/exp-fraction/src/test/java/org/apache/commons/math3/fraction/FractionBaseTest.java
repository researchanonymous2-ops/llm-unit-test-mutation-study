package org.apache.commons.math3.fraction;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PIT.
 * Objetivo exclusivo: executar linhas relevantes do método
 * public static Fraction getReducedFraction(int numerator, int denominator).
 */
public class FractionBaseTest {

    @Test
    void testGetReducedFractionWithDenominatorZero() {
        assertThrows(MathArithmeticException.class, () ->
            Fraction.getReducedFraction(1, 0)
        );
    }

    @Test
    void testGetReducedFractionWithZeroNumerator() {
        Fraction.getReducedFraction(0, 5);
    }

    @Test
    void testGetReducedFractionWithReducibleFraction() {
        Fraction.getReducedFraction(2, 4);
    }

    @Test
    void testGetReducedFractionWithNegativeDenominator() {
        Fraction.getReducedFraction(1, -2);
    }

    @Test
    void testGetReducedFractionWithMinValueDenominatorAndEvenNumerator() {
        Fraction.getReducedFraction(2, Integer.MIN_VALUE);
    }
}


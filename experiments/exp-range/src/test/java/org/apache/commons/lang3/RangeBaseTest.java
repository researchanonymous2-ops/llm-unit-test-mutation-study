package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PIT.
 * Objetivo exclusivo: executar linhas relevantes do método
 * elementCompareTo(T element) da classe Range.
 */
public class RangeBaseTest {

    @Test
    void testElementCompareToBeforeRange() {
        Range<Integer> range = Range.between(10, 20);
        int result = range.elementCompareTo(5);
        assertEquals(-1, result);
    }

    @Test
    void testElementCompareToInsideRange() {
        Range<Integer> range = Range.between(10, 20);
        int result = range.elementCompareTo(15);
        assertEquals(0, result);
    }

    @Test
    void testElementCompareToAfterRange() {
        Range<Integer> range = Range.between(10, 20);
        int result = range.elementCompareTo(30);
        assertEquals(1, result);
    }

    @Test
    void testElementCompareToNullThrowsException() {
        Range<Integer> range = Range.between(10, 20);
        assertThrows(NullPointerException.class,
                () -> range.elementCompareTo(null));
    }
}


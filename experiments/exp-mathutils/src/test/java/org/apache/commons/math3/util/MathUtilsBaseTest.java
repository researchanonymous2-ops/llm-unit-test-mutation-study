package org.apache.commons.math3.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MathUtilsBaseTest {

    @Test
    void testCheckFinite_withAllFiniteValues_shouldNotThrowException() {
        double[] values = {1.0, -2.5, 0.0, 3.14};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withNaNValue_shouldThrowNotFiniteNumberException() {
        double[] values = {1.0, Double.NaN, 2.0};
        assertThrows(Exception.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withInfiniteValue_shouldThrowNotFiniteNumberException() {
        double[] values = {1.0, Double.POSITIVE_INFINITY};
        assertThrows(Exception.class, () -> MathUtils.checkFinite(values));
    }
}


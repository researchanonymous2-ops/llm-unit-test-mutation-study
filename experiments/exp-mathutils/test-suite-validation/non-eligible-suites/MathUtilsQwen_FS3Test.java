package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsQwen_FS3Test {

    @Test
    void testCheckFinite_withNullArray_shouldNotThrowException() {
        assertDoesNotThrow(() -> MathUtils.checkFinite(null));
    }

    @Test
    void testCheckFinite_withEmptyArray_shouldNotThrowException() {
        double[] values = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withAllFiniteValues_shouldNotThrowException() {
        double[] values = {1.5, -2.3, 0.0, Double.MAX_VALUE, Double.MIN_VALUE};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withSingleNaNValue_shouldThrowNotFiniteNumberException() {
        double[] values = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withSinglePositiveInfinityValue_shouldThrowNotFiniteNumberException() {
        double[] values = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withSingleNegativeInfinityValue_shouldThrowNotFiniteNumberException() {
        double[] values = {Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withMixedFiniteAndInfiniteValues_shouldThrowNotFiniteNumberException() {
        double[] values = {1.0, 2.0, Double.POSITIVE_INFINITY, 4.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withMixedFiniteAndNaNValues_shouldThrowNotFiniteNumberException() {
        double[] values = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withAllInfiniteValues_shouldThrowNotFiniteNumberException() {
        double[] values = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withAllNaNValues_shouldThrowNotFiniteNumberException() {
        double[] values = {Double.NaN, Double.NaN, Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }
}
// ```
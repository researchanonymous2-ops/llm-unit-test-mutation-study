package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsQwen_FS2Test {

    @Test
    void testCheckFinite_withNullArray() {
        assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(null));
    }

    @Test
    void testCheckFinite_withEmptyArray() {
        double[] values = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withAllFiniteValues() {
        double[] values = {1.5, -2.3, 0.0, Double.MAX_VALUE, Double.MIN_VALUE};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withSingleNaNValue() {
        double[] values = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withSinglePositiveInfinity() {
        double[] values = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withSingleNegativeInfinity() {
        double[] values = {Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withMixedFiniteAndInfiniteValues_firstElementInfinite() {
        double[] values = {Double.NEGATIVE_INFINITY, 1.0, 2.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withMixedFiniteAndNaNValues_middleElementNaN() {
        double[] values = {1.0, Double.NaN, 2.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withAllInfiniteValues() {
        double[] values = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withVerySmallFiniteNumbers() {
        double[] values = {1e-300, -1e-300, 0.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_withVeryLargeFiniteNumbers() {
        double[] values = {1e300, -1e300, Double.MAX_VALUE};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }
}
// ```
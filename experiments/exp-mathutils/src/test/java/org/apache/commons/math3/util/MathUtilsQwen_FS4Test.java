package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsQwen_FS4Test {

    @Test
    void testCheckFinite_EmptyArray() {
        double[] values = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_AllFiniteValues() {
        double[] values = {1.5, -2.3, 0.0, Double.MAX_VALUE, Double.MIN_VALUE};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_SingleNaNValue() {
        double[] values = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_SinglePositiveInfinity() {
        double[] values = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_SingleNegativeInfinity() {
        double[] values = {Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_MixedFiniteAndNaN() {
        double[] values = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_MixedFiniteAndInfinities() {
        double[] values = {Double.NEGATIVE_INFINITY, 2.0, Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_NaNAndInfinities() {
        double[] values = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }
}
// ```
package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsQwen_OS5Test {

    @Test
    void testCheckFinite_allFiniteValues() {
        double[] values = {1.5, -2.3, 0.0, Double.MAX_VALUE, Double.MIN_VALUE};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_emptyArray() {
        double[] values = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_singleNaN() {
        double[] values = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_singlePositiveInfinity() {
        double[] values = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_singleNegativeInfinity() {
        double[] values = {Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_mixedFiniteAndInfinite() {
        double[] values = {1.0, Double.POSITIVE_INFINITY, -3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_mixedFiniteAndNaN() {
        double[] values = {1.0, Double.NaN, -3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_allNaN() {
        double[] values = {Double.NaN, Double.NaN, Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_allInfinities() {
        double[] values = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }
}
// ```
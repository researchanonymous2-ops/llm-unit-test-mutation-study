package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsQwen_OS1Test {

    @Test
    void testCheckFinite_allFiniteValues() {
        double[] values = {1.0, 2.5, 3.14, -7.8};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_containsNaN() {
        double[] values = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_containsPositiveInfinity() {
        double[] values = {1.0, 2.0, Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_containsNegativeInfinity() {
        double[] values = {Double.NEGATIVE_INFINITY, 2.0, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
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
    void testCheckFinite_mixedNonFinite() {
        double[] values = {1.0, Double.NaN, Double.POSITIVE_INFINITY, -3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_allZeros() {
        double[] values = {0.0, -0.0, 0.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }
}
// ```
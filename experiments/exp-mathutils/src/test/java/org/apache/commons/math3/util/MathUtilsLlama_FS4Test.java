package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsLlama_FS4Test {

    @Test
    void testCheckFinite_NullArrayThrowsException() {
        double[] values = null;
        assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_EmptyArrayDoesNotThrowException() {
        double[] values = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_FiniteValuesDoesNotThrowException() {
        double[] values = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_NaNValueThrowsException() {
        double[] values = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_InfiniteValueThrowsException() {
        double[] values = {1.0, Double.POSITIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_NegativeInfiniteValueThrowsException() {
        double[] values = {1.0, Double.NEGATIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }
}
// ```
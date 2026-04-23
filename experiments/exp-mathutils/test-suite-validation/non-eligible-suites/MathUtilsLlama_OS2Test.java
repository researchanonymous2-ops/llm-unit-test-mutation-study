package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsLlama_OS2Test {

    @Test
    void testCheckFinite_NullArray() {
        double[] values = null;
        assertThrows(NullArgumentException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_EmptyArray() {
        double[] values = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_FiniteValues() {
        double[] values = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_InfiniteValue() {
        double[] values = {1.0, Double.POSITIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_NaNValue() {
        double[] values = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }

    @Test
    void testCheckFinite_NegativeInfiniteValue() {
        double[] values = {1.0, Double.NEGATIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
    }
}
// ```
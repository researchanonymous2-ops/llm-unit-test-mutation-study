package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_ZS4Test {

    @Test
    void testCheckFinite_validArray() {
        double[] val = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    void testCheckFinite_emptyArray() {
        double[] val = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    void testCheckFinite_arrayWithInfinity() {
        double[] val = {1.0, Double.POSITIVE_INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_arrayWithNaN() {
        double[] val = {1.0, 2.0, Double.NaN};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_arrayWithNegativeInfinity() {
        double[] val = {Double.NEGATIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(0, exception.getArguments().length);
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_arrayWithMultipleNonFiniteValues() {
        double[] val = {1.0, Double.NaN, Double.POSITIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_nullArray() {
        double[] val = null;
        assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(val));
    }
}
// ```
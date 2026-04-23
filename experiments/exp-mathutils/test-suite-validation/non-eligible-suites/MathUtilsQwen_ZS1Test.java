package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_ZS1Test {

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
    void testCheckFinite_singleValidElement() {
        double[] val = {42.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    void testCheckFinite_containsInfinity() {
        double[] val = {1.0, Double.POSITIVE_INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_containsNaN() {
        double[] val = {1.0, 2.0, Double.NaN};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_allInvalid() {
        double[] val = {Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments().length);
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_firstElementNaN() {
        double[] val = {Double.NaN, 2.0, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments().length);
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_lastElementInfinite() {
        double[] val = {1.0, 2.0, Double.NEGATIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_negativeZero() {
        double[] val = {-0.0, 1.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    void testCheckFinite_positiveZero() {
        double[] val = {0.0, 1.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }
}
// ```
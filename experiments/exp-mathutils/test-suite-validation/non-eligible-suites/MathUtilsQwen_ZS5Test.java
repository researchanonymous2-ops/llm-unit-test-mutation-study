package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_ZS5Test {

    @Test
    void testCheckFinite_nullArray() {
        assertThrows(NullPointerException.class, () -> {
            MathUtils.checkFinite(null);
        });
    }

    @Test
    void testCheckFinite_emptyArray() {
        assertDoesNotThrow(() -> {
            MathUtils.checkFinite(new double[0]);
        });
    }

    @Test
    void testCheckFinite_allFiniteValues() {
        assertDoesNotThrow(() -> {
            MathUtils.checkFinite(new double[]{1.0, 2.0, 3.0});
        });
    }

    @Test
    void testCheckFinite_containsNaN() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, Double.NaN, 3.0});
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_containsPositiveInfinity() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, Double.POSITIVE_INFINITY, 3.0});
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_containsNegativeInfinity() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, Double.NEGATIVE_INFINITY, 3.0});
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_firstElementInvalid() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{Double.NaN, 1.0, 2.0});
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments().length);
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_lastElementInvalid() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, 2.0, Double.POSITIVE_INFINITY});
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_allNonFinite() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY});
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments()[0]);
    }
}
// ```
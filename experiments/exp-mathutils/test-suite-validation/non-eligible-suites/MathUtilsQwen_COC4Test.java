package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_COC4Test {

    @Test
    void testCheckFinite_withNullArray() {
        assertThrows(NullPointerException.class, () -> {
            MathUtils.checkFinite(null);
        });
    }

    @Test
    void testCheckFinite_withEmptyArray() {
        assertDoesNotThrow(() -> {
            MathUtils.checkFinite(new double[0]);
        });
    }

    @Test
    void testCheckFinite_withAllFiniteValues() {
        assertDoesNotThrow(() -> {
            MathUtils.checkFinite(new double[]{1.0, 2.0, 3.0});
        });
    }

    @Test
    void testCheckFinite_withInfiniteValueAtStart() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{Double.POSITIVE_INFINITY, 2.0, 3.0});
        });
        assertEquals(0, exception.getArguments()[1]);
    }

    @Test
    void testCheckFinite_withNaNValueAtStart() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{Double.NaN, 2.0, 3.0});
        });
        assertEquals(0, exception.getArguments()[1]);
    }

    @Test
    void testCheckFinite_withInfiniteValueAtMiddle() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, Double.NEGATIVE_INFINITY, 3.0});
        });
        assertEquals(1, exception.getArguments()[1]);
    }

    @Test
    void testCheckFinite_withNaNValueAtMiddle() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, Double.NaN, 3.0});
        });
        assertEquals(1, exception.getArguments()[1]);
    }

    @Test
    void testCheckFinite_withInfiniteValueAtEnd() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, 2.0, Double.POSITIVE_INFINITY});
        });
        assertEquals(2, exception.getArguments()[1]);
    }

    @Test
    void testCheckFinite_withNaNValueAtEnd() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, 2.0, Double.NaN});
        });
        assertEquals(2, exception.getArguments()[1]);
    }

    @Test
    void testCheckFinite_withMultipleNonFiniteValues() {
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(new double[]{1.0, Double.NaN, Double.POSITIVE_INFINITY});
        });
        assertEquals(1, exception.getArguments()[1]);
    }
}
// ```
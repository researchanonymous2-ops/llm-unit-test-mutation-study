package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_COC1Test {

    @Test
    void testCheckFinite_NormalValues() {
        double[] input = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(input));
    }

    @Test
    void testCheckFinite_InfiniteValue() {
        double[] input = {1.0, Double.POSITIVE_INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(input));
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_NaNValue() {
        double[] input = {1.0, 2.0, Double.NaN};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(input));
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_EmptyArray() {
        double[] input = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(input));
    }

    @Test
    void testCheckFinite_FirstElementInvalid() {
        double[] input = {Double.NaN, 2.0, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(input));
        assertEquals(0, exception.getArguments().length);
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    void testCheckFinite_NegativeInfiniteValue() {
        double[] input = {1.0, -Double.INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(input));
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }
}
// ```
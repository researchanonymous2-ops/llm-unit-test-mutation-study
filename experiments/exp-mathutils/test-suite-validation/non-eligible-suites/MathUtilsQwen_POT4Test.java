package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_POT4Test {

    @Test
    public void testCheckFinite_ArrayWithNaN() {
        double[] input = {1.0, Double.NaN, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(input);
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_ArrayWithInfinite() {
        double[] input = {1.0, Double.POSITIVE_INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(input);
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_ArrayWithFiniteValues() {
        double[] input = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> {
            MathUtils.checkFinite(input);
        });
    }
}
// ```
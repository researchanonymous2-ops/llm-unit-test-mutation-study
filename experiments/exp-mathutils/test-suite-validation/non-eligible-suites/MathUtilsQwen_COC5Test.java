package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_COC5Test {

    @Test
    public void testCheckFinite_NormalValues() {
        double[] input = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> org.apache.commons.math3.util.MathUtils.checkFinite(input));
    }

    @Test
    public void testCheckFinite_InfiniteValue() {
        double[] input = {1.0, Double.POSITIVE_INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> 
            org.apache.commons.math3.util.MathUtils.checkFinite(input)
        );
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_NaNValue() {
        double[] input = {1.0, 2.0, Double.NaN};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> 
            org.apache.commons.math3.util.MathUtils.checkFinite(input)
        );
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_EmptyArray() {
        double[] input = {};
        assertDoesNotThrow(() -> org.apache.commons.math3.util.MathUtils.checkFinite(input));
    }

    @Test
    public void testCheckFinite_FirstElementInvalid() {
        double[] input = {Double.NaN, 2.0, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> 
            org.apache.commons.math3.util.MathUtils.checkFinite(input)
        );
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments().length);
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_LastElementInvalid() {
        double[] input = {1.0, 2.0, Double.NEGATIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> 
            org.apache.commons.math3.util.MathUtils.checkFinite(input)
        );
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }
}
// ```
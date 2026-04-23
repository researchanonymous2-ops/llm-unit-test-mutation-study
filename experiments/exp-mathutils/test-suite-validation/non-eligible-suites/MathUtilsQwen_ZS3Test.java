package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_ZS3Test {

    @Test
    public void testCheckFinite_validArray() {
        double[] val = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_emptyArray() {
        double[] val = {};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_singleValidElement() {
        double[] val = {42.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_containsInfinite() {
        double[] val = {1.0, Double.POSITIVE_INFINITY, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_containsNaN() {
        double[] val = {1.0, 2.0, Double.NaN};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_allInfinite() {
        double[] val = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_allNaN() {
        double[] val = {Double.NaN, Double.NaN};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(0, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_mixedInvalid() {
        double[] val = {1.0, Double.NaN, Double.POSITIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments()[0]);
    }
}
// ```
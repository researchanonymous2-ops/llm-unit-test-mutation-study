package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_POT3Test {

    @Test
    public void testCheckFinite_NaN() {
        double[] val = {1.0, Double.NaN, 3.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(val);
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(1, exception.getArguments().length);
        assertEquals(1, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_Infinite() {
        double[] val = {1.0, 2.0, Double.POSITIVE_INFINITY};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> {
            MathUtils.checkFinite(val);
        });
        assertEquals(LocalizedFormats.ARRAY_ELEMENT, exception.getPattern());
        assertEquals(2, exception.getArguments().length);
        assertEquals(2, exception.getArguments()[0]);
    }

    @Test
    public void testCheckFinite_FiniteValues() {
        double[] val = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> {
            MathUtils.checkFinite(val);
        });
    }
}
// ```
package org.apache.commons.math3.util;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsGrok_POT5Test {

    @Test
    public void testCheckFinite_WithNaN() {
        double[] arr = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(arr));
    }

    @Test
    public void testCheckFinite_WithInfinite() {
        double[] arr = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(arr));
    }

    @Test
    public void testCheckFinite_WithFiniteValues() {
        double[] arr = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(arr));
    }
}
// ```
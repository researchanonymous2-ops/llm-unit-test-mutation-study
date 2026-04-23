package org.apache.commons.math3.util;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsGrok_POT3Test {

    @Test
    public void testCheckFinite_NaN() {
        double[] array = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(array));
    }

    @Test
    public void testCheckFinite_Infinite() {
        double[] array = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(array));
    }

    @Test
    public void testCheckFinite_Finite() {
        double[] array = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(array));
    }
}
// ```
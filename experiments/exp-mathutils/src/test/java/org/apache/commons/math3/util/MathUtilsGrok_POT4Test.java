package org.apache.commons.math3.util;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;

public class MathUtilsGrok_POT4Test {

    @Test
    public void testCheckFinite_NaN() {
        double[] val = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_Infinite() {
        double[] val = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_Finite() {
        double[] val = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }
}
// ```
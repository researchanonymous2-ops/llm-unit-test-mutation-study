package org.apache.commons.math3.util;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_POT1Test {

    @Test
    void testCheckFinite_NaN() {
        double[] val = {Double.NaN};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
    }

    @Test
    void testCheckFinite_Infinite() {
        double[] val = {Double.POSITIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
    }

    @Test
    void testCheckFinite_Finite() {
        double[] val = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }
}
// ```
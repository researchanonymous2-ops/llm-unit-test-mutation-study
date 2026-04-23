package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsQwen_POT1Test {

    @Test
    public void testCheckFinite_ArrayWithNaN() {
        double[] input = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(input));
    }

    @Test
    public void testCheckFinite_ArrayWithInfinite() {
        double[] input = {1.0, Double.POSITIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(input));
    }

    @Test
    public void testCheckFinite_ArrayWithFiniteValues() {
        double[] input = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(input));
    }
}
// ```
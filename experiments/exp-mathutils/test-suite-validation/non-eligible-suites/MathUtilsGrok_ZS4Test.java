package org.apache.commons.math3.util;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;

public class MathUtilsGrok_ZS4Test {

    @Test
    public void testCheckFinite_EmptyArray() {
        double[] val = new double[0];
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_AllFinite() {
        double[] val = {1.0, 2.5, -3.7, 0.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(val));
    }

    @Test
    public void testCheckFinite_PositiveInfinity() {
        double[] val = {1.0, Double.POSITIVE_INFINITY, 2.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(1, exception.getArgument().get(1));
    }

    @Test
    public void testCheckFinite_NegativeInfinity() {
        double[] val = {1.0, Double.NEGATIVE_INFINITY, 2.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(1, exception.getArgument().get(1));
    }

    @Test
    public void testCheckFinite_NaN() {
        double[] val = {1.0, Double.NaN, 2.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(1, exception.getArgument().get(1));
    }

    @Test
    public void testCheckFinite_MultipleInvalid() {
        double[] val = {Double.NaN, Double.POSITIVE_INFINITY, 1.0};
        NotFiniteNumberException exception = assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
        assertEquals(0, exception.getArgument().get(1));
    }

    @Test
    public void testCheckFinite_NullArray() {
        double[] val = null;
        assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(val));
    }
}
// ```
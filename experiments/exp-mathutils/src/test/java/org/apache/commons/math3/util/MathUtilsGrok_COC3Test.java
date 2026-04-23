package org.apache.commons.math3.util;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;

public class MathUtilsGrok_COC3Test {

    @Test
    public void testCheckFinite_AllFinite() {
        double[] arr = {1.0, 2.0, 3.0};
        MathUtils.checkFinite(arr);
    }

    @Test
    public void testCheckFinite_Infinite() {
        double[] arr = {1.0, Double.POSITIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(arr));
    }

    @Test
    public void testCheckFinite_NaN() {
        double[] arr = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(arr));
    }

    @Test
    public void testCheckFinite_EmptyArray() {
        double[] arr = {};
        MathUtils.checkFinite(arr);
    }

    @Test
    public void testCheckFinite_SingleFinite() {
        double[] arr = {5.0};
        MathUtils.checkFinite(arr);
    }

    @Test
    public void testCheckFinite_SingleInfinite() {
        double[] arr = {Double.NEGATIVE_INFINITY};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(arr));
    }
}
// ```
package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsLlama_COC5Test {

    @Test
    public void testCheckFinite_NullArray() {
        assertThrows(NullPointerException.class, () -> MathUtils.checkFinite((double[]) null));
    }

    @Test
    public void testCheckFinite_EmptyArray() {
        assertDoesNotThrow(() -> MathUtils.checkFinite(new double[0]));
    }

    @Test
    public void testCheckFinite_FiniteValues() {
        double[] finiteValues = {1.0, 2.0, 3.0};
        assertDoesNotThrow(() -> MathUtils.checkFinite(finiteValues));
    }

    @Test
    public void testCheckFinite_InfiniteValue() {
        double[] infiniteValue = {1.0, Double.POSITIVE_INFINITY, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(infiniteValue));
    }

    @Test
    public void testCheckFinite_NaNValue() {
        double[] nanValue = {1.0, Double.NaN, 3.0};
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(nanValue));
    }
}
// ```
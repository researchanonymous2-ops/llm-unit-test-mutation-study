package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsLlama_ZS5Test {

    @Test
    public void testCheckFinite_NullArray() {
        assertThrows(NullArgumentException.class, () -> MathUtils.checkFinite((double[]) null));
    }

    @Test
    public void testCheckFinite_EmptyArray() {
        MathUtils.checkFinite(new double[0]);
    }

    @Test
    public void testCheckFinite_FiniteValues() {
        MathUtils.checkFinite(new double[] {1.0, 2.0, 3.0});
    }

    @Test
    public void testCheckFinite_InfiniteValue() {
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(new double[] {1.0, Double.POSITIVE_INFINITY, 3.0}));
    }

    @Test
    public void testCheckFinite_NaNValue() {
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(new double[] {1.0, Double.NaN, 3.0}));
    }

    @Test
    public void testCheckFinite_MultipleInfiniteValues() {
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(new double[] {Double.POSITIVE_INFINITY, 2.0, Double.NEGATIVE_INFINITY}));
    }

    @Test
    public void testCheckFinite_MultipleNaNValues() {
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(new double[] {Double.NaN, 2.0, Double.NaN}));
    }
}
// ```
package org.apache.commons.math3.util;

// ```java
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsLlama_COC3Test {

    @Test
    public void testCheckFinite_NullArray() {
        assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(null));
    }

    @Test
    public void testCheckFinite_EmptyArray() {
        assertDoesNotThrow(() -> MathUtils.checkFinite(new double[] {}));
    }

    @Test
    public void testCheckFinite_FiniteArray() {
        assertDoesNotThrow(() -> MathUtils.checkFinite(new double[] {1.0, 2.0, 3.0}));
    }

    @Test
    public void testCheckFinite_InfiniteArray() {
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(new double[] {1.0, Double.POSITIVE_INFINITY, 3.0}));
    }

    @Test
    public void testCheckFinite_NaNArray() {
        assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(new double[] {1.0, Double.NaN, 3.0}));
    }
}
// ```
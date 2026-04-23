package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaLlama_OS5Test {

    @Test
    void testSurfaceAreaCone_ValidInput() {
        double result = Area.surfaceAreaCone(3.0, 4.0);
        assertEquals(Math.PI * 3.0 * (3.0 + 5.0), result);
    }

    @Test
    void testSurfaceAreaCone_ZeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 4.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3.0, 4.0));
    }

    @Test
    void testSurfaceAreaCone_ZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -4.0));
    }

    @Test
    void testSurfaceAreaCone_BothZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_BothNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3.0, -4.0));
    }
}
// ```
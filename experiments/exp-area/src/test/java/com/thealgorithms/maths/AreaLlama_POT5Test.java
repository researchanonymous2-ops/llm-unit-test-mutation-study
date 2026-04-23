package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.thealgorithms.maths.Area;

public class AreaLlama_POT5Test {

    @Test
    public void testSurfaceAreaCone_RadiusNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
    }

    @Test
    public void testSurfaceAreaCone_HeightNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
    }

    @Test
    public void testSurfaceAreaCone_ValidInput() {
        double radius = 5;
        double height = 10;
        double result = Area.surfaceAreaCone(radius, height);
        assertTrue(result > 0);
    }
}
// ```
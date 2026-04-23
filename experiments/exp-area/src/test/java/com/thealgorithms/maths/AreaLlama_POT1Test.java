package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.thealgorithms.maths.Area;

public class AreaLlama_POT1Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, -1));
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
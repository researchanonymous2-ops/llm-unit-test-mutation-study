package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.thealgorithms.maths.Area;

public class AreaLlama_COC2Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        double radius = -1.0;
        double height = 2.0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
        assertEquals(Area.POSITIVE_RADIUS, exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        double radius = 1.0;
        double height = -2.0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
        assertEquals(Area.POSITIVE_HEIGHT, exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_ValidInput() {
        double radius = 1.0;
        double height = 2.0;
        double expected = Math.PI * radius * (radius + Math.pow(height * height + radius * radius, 0.5));
        double actual = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, actual, 1e-9);
    }
}
// ```
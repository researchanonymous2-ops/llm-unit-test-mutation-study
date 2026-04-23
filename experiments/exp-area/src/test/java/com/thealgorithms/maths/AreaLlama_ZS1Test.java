package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaLlama_ZS1Test {

    @Test
    public void testSurfaceAreaCone_ValidInput() {
        double radius = 5.0;
        double height = 10.0;
        double expected = Math.PI * radius * (radius + Math.pow(height * height + radius * radius, 0.5));
        double actual = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSurfaceAreaCone_NegativeRadius() {
        double radius = -5.0;
        double height = 10.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_NegativeHeight() {
        double radius = 5.0;
        double height = -10.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_ZeroRadius() {
        double radius = 0.0;
        double height = 10.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_ZeroHeight() {
        double radius = 5.0;
        double height = 0.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }
}
// ```
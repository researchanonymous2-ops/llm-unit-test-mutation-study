package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaGrok_ZS2Test {

    @Test
    public void testSurfaceAreaCone_ValidInputs() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }

    @Test
    public void testSurfaceAreaCone_ZeroRadius() {
        double radius = 0.0;
        double height = 4.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_NegativeRadius() {
        double radius = -1.0;
        double height = 4.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_ZeroHeight() {
        double radius = 3.0;
        double height = 0.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_NegativeHeight() {
        double radius = 3.0;
        double height = -1.0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height));
    }

    @Test
    public void testSurfaceAreaCone_LargeValues() {
        double radius = 1000.0;
        double height = 1000.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-6);
    }

    @Test
    public void testSurfaceAreaCone_SmallValues() {
        double radius = 0.1;
        double height = 0.1;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
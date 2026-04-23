package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaGrok_ZS4Test {

    @Test
    void testSurfaceAreaCone_ValidInputs() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }

    @Test
    void testSurfaceAreaCone_ZeroRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCone_NegativeRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 1));
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCone_ZeroHeight() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCone_NegativeHeight() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, -1));
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCone_LargeValues() {
        double radius = 1000.0;
        double height = 1000.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-6);
    }

    @Test
    void testSurfaceAreaCone_SmallValues() {
        double radius = 0.1;
        double height = 0.1;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
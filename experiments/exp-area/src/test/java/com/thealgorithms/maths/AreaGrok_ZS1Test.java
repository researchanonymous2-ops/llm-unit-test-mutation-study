package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaGrok_ZS1Test {

    @Test
    void testSurfaceAreaCone_ValidInputs() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }

    @Test
    void testSurfaceAreaCone_ZeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_ZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -1.0));
    }

    @Test
    void testSurfaceAreaCone_LargeValues() {
        double radius = 1000.0;
        double height = 1000.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-6);
    }
}
// ```
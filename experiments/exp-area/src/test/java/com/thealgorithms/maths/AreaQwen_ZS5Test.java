package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_ZS5Test {

    @Test
    void testSurfaceAreaCone_validInput() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }

    @Test
    void testSurfaceAreaCone_radiusZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_radiusNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_heightZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_heightNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5.0, -1.0));
    }

    @Test
    void testSurfaceAreaCone_bothZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_bothNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, -1.0));
    }

    @Test
    void testSurfaceAreaCone_fractionalValues() {
        double radius = 0.5;
        double height = 1.5;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }

    @Test
    void testSurfaceAreaCone_largeValues() {
        double radius = 1000.0;
        double height = 5000.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-5);
    }
}
// ```
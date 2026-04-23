package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_ZS4Test {

    @Test
    public void testSurfaceAreaCone_validInput() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-10);
    }

    @Test
    public void testSurfaceAreaCone_radiusZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 5));
    }

    @Test
    public void testSurfaceAreaCone_radiusNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 5));
    }

    @Test
    public void testSurfaceAreaCone_heightZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, 0));
    }

    @Test
    public void testSurfaceAreaCone_heightNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, -1));
    }

    @Test
    public void testSurfaceAreaCone_bothZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 0));
    }

    @Test
    public void testSurfaceAreaCone_bothNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, -1));
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_POT2Test {

    @Test
    public void testSurfaceAreaCone_radiusZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 5));
    }

    @Test
    public void testSurfaceAreaCone_radiusNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3, 5));
    }

    @Test
    public void testSurfaceAreaCone_heightZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, 0));
    }

    @Test
    public void testSurfaceAreaCone_heightNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, -3));
    }

    @Test
    public void testSurfaceAreaCone_validInput() {
        double radius = 3;
        double height = 4;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
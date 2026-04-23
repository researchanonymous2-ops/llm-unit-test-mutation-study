package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_ZS2Test {

    @Test
    void testSurfaceAreaCone_validInput() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-10);
    }

    @Test
    void testSurfaceAreaCone_zeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 5));
    }

    @Test
    void testSurfaceAreaCone_negativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3, 5));
    }

    @Test
    void testSurfaceAreaCone_zeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3, 0));
    }

    @Test
    void testSurfaceAreaCone_negativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3, -5));
    }

    @Test
    void testSurfaceAreaCone_bothZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 0));
    }

    @Test
    void testSurfaceAreaCone_fractionalValues() {
        double radius = 1.5;
        double height = 2.5;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-10);
    }
}
// ```
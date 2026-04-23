package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_OS5Test {

    @Test
    void testSurfaceAreaCone_validInput1() {
        double radius = 5.0;
        double height = 12.0;
        double slantHeight = Math.sqrt(radius * radius + height * height);
        double expected = Math.PI * radius * (radius + slantHeight);
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_validInput2() {
        double radius = 1.0;
        double height = 1.0;
        double slantHeight = Math.sqrt(2);
        double expected = Math.PI * (1 + slantHeight);
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_validInput3() {
        double radius = 7.5;
        double height = 10.0;
        double slantHeight = Math.sqrt(7.5 * 7.5 + 10 * 10);
        double expected = Math.PI * 7.5 * (7.5 + slantHeight);
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_radiusZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_radiusNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3.0, 4.0));
    }

    @Test
    void testSurfaceAreaCone_heightZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_heightNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -4.0));
    }

    @Test
    void testSurfaceAreaCone_bothZero() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_bothNegative() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, -1.0));
    }
}
// ```
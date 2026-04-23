package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_FS3Test {

    @Test
    void testSurfaceAreaCone_validInput1() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_validInput2() {
        double radius = 5.0;
        double height = 12.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_validInput3() {
        double radius = 1.0;
        double height = 1.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_radiusZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3.0, 4.0));
    }

    @Test
    void testSurfaceAreaCone_heightZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_negativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -4.0));
    }

    @Test
    void testSurfaceAreaCone_bothZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_bothNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, -2.0));
    }
}
// ```
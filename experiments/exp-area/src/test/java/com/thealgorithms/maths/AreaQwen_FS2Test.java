package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_FS2Test {

    @Test
    void testSurfaceAreaCone_ValidInputOne() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_ValidInputTwo() {
        double radius = 5.0;
        double height = 12.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_ZeroRadius_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeRadius_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-2.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_ZeroHeight_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeHeight_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5.0, -3.0));
    }

    @Test
    void testSurfaceAreaCone_BothZero_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_FractionalValues() {
        double radius = 1.5;
        double height = 2.5;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }
}
// ```
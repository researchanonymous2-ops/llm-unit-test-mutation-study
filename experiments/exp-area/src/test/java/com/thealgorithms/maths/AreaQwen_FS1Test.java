package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_FS1Test {

    @Test
    void testSurfaceAreaCone_validInput1() {
        double result = Area.surfaceAreaCone(3.0, 4.0);
        double expected = Math.PI * 3.0 * (3.0 + Math.sqrt(4.0 * 4.0 + 3.0 * 3.0));
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_validInput2() {
        double result = Area.surfaceAreaCone(5.0, 12.0);
        double expected = Math.PI * 5.0 * (5.0 + Math.sqrt(12.0 * 12.0 + 5.0 * 5.0));
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_radiusZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(-2.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_heightZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(3.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_negativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(3.0, -4.0));
    }

    @Test
    void testSurfaceAreaCone_bothZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_smallValues() {
        double result = Area.surfaceAreaCone(0.1, 0.1);
        double expected = Math.PI * 0.1 * (0.1 + Math.sqrt(0.1 * 0.1 + 0.1 * 0.1));
        assertEquals(expected, result);
    }
}
// ```
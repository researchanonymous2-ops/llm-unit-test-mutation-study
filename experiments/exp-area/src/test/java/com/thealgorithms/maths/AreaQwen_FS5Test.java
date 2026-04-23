package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_FS5Test {

    @Test
    void testSurfaceAreaCone_validInput1() {
        double result = Area.surfaceAreaCone(3.0, 4.0);
        assertEquals(Math.PI * 3.0 * (3.0 + Math.sqrt(4.0 * 4.0 + 3.0 * 3.0)), result);
    }

    @Test
    void testSurfaceAreaCone_validInput2() {
        double result = Area.surfaceAreaCone(5.0, 12.0);
        assertEquals(Math.PI * 5.0 * (5.0 + Math.sqrt(12.0 * 12.0 + 5.0 * 5.0)), result);
    }

    @Test
    void testSurfaceAreaCone_validInput3() {
        double result = Area.surfaceAreaCone(1.0, 1.0);
        assertEquals(Math.PI * 1.0 * (1.0 + Math.sqrt(1.0 * 1.0 + 1.0 * 1.0)), result);
    }

    @Test
    void testSurfaceAreaCone_radiusZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(-2.0, 3.0));
    }

    @Test
    void testSurfaceAreaCone_heightZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(4.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_negativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(3.0, -1.0));
    }

    @Test
    void testSurfaceAreaCone_bothZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_bothNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(-1.0, -1.0));
    }
}
// ```
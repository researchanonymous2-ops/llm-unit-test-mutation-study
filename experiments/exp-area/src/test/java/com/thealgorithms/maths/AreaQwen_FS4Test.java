package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_FS4Test {

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
    void testSurfaceAreaCone_radiusZero() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_negativeRadius() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(-3.0, 4.0));
    }

    @Test
    void testSurfaceAreaCone_heightZero() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(3.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_negativeHeight() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(3.0, -4.0));
    }

    @Test
    void testSurfaceAreaCone_bothZero() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_largeValues() {
        double result = Area.surfaceAreaCone(100.0, 200.0);
        assertEquals(Math.PI * 100.0 * (100.0 + Math.sqrt(200.0 * 200.0 + 100.0 * 100.0)), result);
    }
}
// ```
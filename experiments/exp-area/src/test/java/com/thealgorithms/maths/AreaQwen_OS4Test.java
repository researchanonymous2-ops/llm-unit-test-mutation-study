package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_OS4Test {

    @Test
    void testSurfaceAreaCone_validInput1() {
        double result = Area.surfaceAreaCone(5.0, 12.0);
        double expected = Math.PI * 5.0 * (5.0 + Math.sqrt(12.0 * 12.0 + 5.0 * 5.0));
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_validInput2() {
        double result = Area.surfaceAreaCone(1.0, 1.0);
        double expected = Math.PI * 1.0 * (1.0 + Math.sqrt(1.0 * 1.0 + 1.0 * 1.0));
        assertEquals(expected, result);
    }

    @Test
    void testSurfaceAreaCone_validInput3() {
        double result = Area.surfaceAreaCone(7.5, 10.0);
        double expected = Math.PI * 7.5 * (7.5 + Math.sqrt(10.0 * 10.0 + 7.5 * 7.5));
        assertEquals(expected, result);
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
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(6.0, -2.0));
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
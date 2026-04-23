package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaLlama_FS2Test {

    @Test
    void testSurfaceAreaCone_ValidInput() {
        double result = Area.surfaceAreaCone(2.0, 3.0);
        double expected = Math.PI * 2.0 * (2.0 + Math.sqrt(2.0 * 2.0 + 3.0 * 3.0));
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_AnotherValidInput() {
        double result = Area.surfaceAreaCone(1.5, 4.0);
        double expected = Math.PI * 1.5 * (1.5 + Math.sqrt(1.5 * 1.5 + 4.0 * 4.0));
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_InvalidRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(0.0, 2.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(-1.0, 2.0));
    }

    @Test
    void testSurfaceAreaCone_InvalidHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(2.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_NegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Area.surfaceAreaCone(2.0, -1.0));
    }
}
// ```
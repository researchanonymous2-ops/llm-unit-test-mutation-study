package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AreaGrok_COC2Test {

    @Test
    void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 5));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 5));
    }

    @Test
    void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, 0));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, -1));
    }

    @Test
    void testSurfaceAreaCone_ValidInputs() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
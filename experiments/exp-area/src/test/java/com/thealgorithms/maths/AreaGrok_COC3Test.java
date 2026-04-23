package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AreaGrok_COC3Test {

    @Test
    void testSurfaceAreaCone_InvalidRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCone_InvalidHeight() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCone_Valid() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
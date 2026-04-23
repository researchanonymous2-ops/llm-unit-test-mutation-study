package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AreaGrok_COC4Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1), "Must be a positive radius");
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 1), "Must be a positive radius");
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0), "Must be a positive height");
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, -1), "Must be a positive height");
    }

    @Test
    public void testSurfaceAreaCone_ValidInputs() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AreaGrok_POT1Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 5));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 5));
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, 0));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5, -1));
    }

    @Test
    public void testSurfaceAreaCone_ValidInputs() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double actual = Area.surfaceAreaCone(radius, height);
        assertTrue(actual > 0);
        assertEquals(expected, actual, 1e-9);
    }
}
// ```
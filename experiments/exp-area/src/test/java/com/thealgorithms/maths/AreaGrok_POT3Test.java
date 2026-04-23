package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaGrok_POT3Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(0, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(-1, 5);
        });
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5, -1);
        });
    }

    @Test
    public void testSurfaceAreaCone_ValidInputs() {
        double radius = 3;
        double height = 4;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
        assertTrue(Area.surfaceAreaCone(radius, height) > 0);
    }
}
// ```

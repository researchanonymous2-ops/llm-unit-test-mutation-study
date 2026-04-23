package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaGrok_POT2Test {

    @Test
    void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
    }

    @Test
    void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
    }

    @Test
    void testSurfaceAreaCone_Valid() {
        double radius = 1.0;
        double height = 1.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 0.0001);
        assertTrue(result > 0);
    }
}
// ```
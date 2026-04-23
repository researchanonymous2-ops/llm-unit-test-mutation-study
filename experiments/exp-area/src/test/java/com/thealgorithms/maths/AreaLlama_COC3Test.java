package com.thealgorithms.maths;

// ```java
import com.thealgorithms.maths.Area;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaLlama_COC3Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, -1));
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
    }

    @Test
    public void testSurfaceAreaCone_ValidInput() {
        double radius = 5;
        double height = 10;
        double expected = Math.PI * radius * (radius + Math.pow(height * height + radius * radius, 0.5));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-6);
    }
}
// ```
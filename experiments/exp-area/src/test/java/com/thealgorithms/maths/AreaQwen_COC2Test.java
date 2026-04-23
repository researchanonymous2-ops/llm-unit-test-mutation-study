package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_COC2Test {

    @Test
    public void testSurfaceAreaCone_NegativeRadius_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(-5.0, 10.0);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_ZeroRadius_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(0.0, 10.0);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_NegativeHeight_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5.0, -10.0);
        });
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_ZeroHeight_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5.0, 0.0);
        });
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_ValidInputs_CalculatesCorrectly() {
        double radius = 3.0;
        double height = 4.0;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
    }
}
// ```
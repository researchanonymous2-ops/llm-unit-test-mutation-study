package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_COC4Test {

    @Test
    public void testSurfaceAreaCone_negativeRadius() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(-1, 5);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_zeroRadius() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(0, 5);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_negativeHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5, -1);
        });
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_zeroHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5, 0);
        });
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    public void testSurfaceAreaCone_validInputs() {
        double result = Area.surfaceAreaCone(3, 4);
        double expected = Math.PI * 3 * (3 + Math.sqrt(4 * 4 + 3 * 3));
        assertEquals(expected, result, 1e-9);
    }
}
// ```
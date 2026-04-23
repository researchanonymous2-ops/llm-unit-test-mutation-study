package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_COC5Test {

    @Test
    public void testSurfaceAreaCone_negativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(-1, 5);
        });
    }

    @Test
    public void testSurfaceAreaCone_zeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(0, 5);
        });
    }

    @Test
    public void testSurfaceAreaCone_negativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5, -1);
        });
    }

    @Test
    public void testSurfaceAreaCone_zeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCone(5, 0);
        });
    }

    @Test
    public void testSurfaceAreaCone_validInput() {
        double result = Area.surfaceAreaCone(3, 4);
        double expected = Math.PI * 3 * (3 + Math.sqrt(4 * 4 + 3 * 3));
        assertEquals(expected, result, 1e-9);
    }
}
// ```
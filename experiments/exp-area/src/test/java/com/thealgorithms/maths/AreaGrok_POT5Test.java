package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AreaGrok_POT5Test {

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
        double result = Area.surfaceAreaCone(3, 4);
        assertTrue(result > 0);
    }
}
// ```
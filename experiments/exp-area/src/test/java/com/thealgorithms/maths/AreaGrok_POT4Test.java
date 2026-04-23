package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AreaGrok_POT4Test {

    @Test
    public void testSurfaceAreaCone_InvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
    }

    @Test
    public void testSurfaceAreaCone_InvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
    }

    @Test
    public void testSurfaceAreaCone_ValidInputs() {
        double result = Area.surfaceAreaCone(1, 1);
        assertTrue(result > 0);
    }
}
// ```
package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaQwen_COC3Test {

    @Test
    public void testSurfaceAreaCone_NegativeRadius_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-5, 10));
    }

    @Test
    public void testSurfaceAreaCone_ZeroRadius_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 10));
    }

    @Test
    public void testSurfaceAreaCone_NegativeHeight_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(10, -5));
    }

    @Test
    public void testSurfaceAreaCone_ZeroHeight_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(10, 0));
    }

    @Test
    public void testSurfaceAreaCone_ValidInput_ReturnsCorrectValue() {
        double result = Area.surfaceAreaCone(3, 4);
        double expected = Math.PI * 3 * (3 + Math.sqrt(4 * 4 + 3 * 3));
        assertEquals(expected, result, 1e-10);
    }
}
// ```
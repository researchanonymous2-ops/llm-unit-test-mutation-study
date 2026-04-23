package com.thealgorithms.maths;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaQwen_OS3Test {

    @Test
    void testSurfaceAreaCone_validInput_positiveResult() {
        double radius = 5.0;
        double height = 12.0;
        double slantHeight = Math.sqrt(radius * radius + height * height);
        double expected = Math.PI * radius * (radius + slantHeight);
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_decimalValues_correctComputation() {
        double radius = 2.5;
        double height = 6.0;
        double slantHeight = Math.sqrt(radius * radius + height * height);
        double expected = Math.PI * radius * (radius + slantHeight);
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    void testSurfaceAreaCone_largeNumbers_accurateResult() {
        double radius = 100.0;
        double height = 300.0;
        double slantHeight = Math.sqrt(radius * radius + height * height);
        double expected = Math.PI * radius * (radius + slantHeight);
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testSurfaceAreaCone_minimumValidValues_finiteResult() {
        double radius = 0.0001;
        double height = 0.0001;
        double result = Area.surfaceAreaCone(radius, height);
        assert(result > 0 && Double.isFinite(result));
    }

    @Test
    void testSurfaceAreaCone_zeroRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
    }

    @Test
    void testSurfaceAreaCone_negativeRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-3.0, 4.0));
    }

    @Test
    void testSurfaceAreaCone_zeroHeight_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(5.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_negativeHeight_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -4.0));
    }

    @Test
    void testSurfaceAreaCone_bothZero_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 0.0));
    }

    @Test
    void testSurfaceAreaCone_bothNegative_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, -2.0));
    }
}
// ```
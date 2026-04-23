package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaGrok_FS3Test {

   @Test
   void testSurfaceAreaCone_ValidInputs() {
       double result = Area.surfaceAreaCone(3.0, 4.0);
       double expected = Math.PI * 3.0 * (3.0 + Math.sqrt(16.0 + 9.0));
       assertEquals(expected, result, 1e-9);
   }

   @Test
   void testSurfaceAreaCone_AnotherValidInputs() {
       double result = Area.surfaceAreaCone(1.0, 1.0);
       double expected = Math.PI * 1.0 * (1.0 + Math.sqrt(1.0 + 1.0));
       assertEquals(expected, result, 1e-9);
   }

   @Test
   void testSurfaceAreaCone_ThirdValidInputs() {
       double result = Area.surfaceAreaCone(0.5, 2.0);
       double expected = Math.PI * 0.5 * (0.5 + Math.sqrt(4.0 + 0.25));
       assertEquals(expected, result, 1e-9);
   }

   @Test
   void testSurfaceAreaCone_InvalidRadiusZero() {
       assertThrows(IllegalArgumentException.class,
           () -> Area.surfaceAreaCone(0.0, 2.0));
   }

   @Test
   void testSurfaceAreaCone_InvalidRadiusNegative() {
       assertThrows(IllegalArgumentException.class,
           () -> Area.surfaceAreaCone(-1.0, 2.0));
   }

   @Test
   void testSurfaceAreaCone_InvalidHeightZero() {
       assertThrows(IllegalArgumentException.class,
           () -> Area.surfaceAreaCone(2.0, 0.0));
   }

   @Test
   void testSurfaceAreaCone_InvalidHeightNegative() {
       assertThrows(IllegalArgumentException.class,
           () -> Area.surfaceAreaCone(2.0, -1.0));
   }
}

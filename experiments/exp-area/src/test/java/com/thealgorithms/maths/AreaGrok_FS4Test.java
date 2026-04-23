package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaGrok_FS4Test {

   @Test
   void testSurfaceAreaCone_ValidInputs() {
       double result = Area.surfaceAreaCone(3.0, 4.0);
       assertEquals(Math.PI * 3.0 * (3.0 + Math.sqrt(25.0)), result);
   }

   @Test
   void testSurfaceAreaCone_AnotherValidInputs() {
       double result = Area.surfaceAreaCone(1.0, 2.0);
       assertEquals(Math.PI * 1.0 * (1.0 + Math.sqrt(5.0)), result);
   }

   @Test
   void testSurfaceAreaCone_ThirdValidInputs() {
       double result = Area.surfaceAreaCone(0.5, 1.5);
       assertEquals(Math.PI * 0.5 * (0.5 + Math.sqrt(2.5)), result);
   }

   @Test
   void testSurfaceAreaCone_InvalidRadiusZero() {
       assertThrows(IllegalArgumentException.class,
           () -> Area.surfaceAreaCone(0.0, 5.0));
   }

   @Test
   void testSurfaceAreaCone_InvalidRadiusNegative() {
       assertThrows(IllegalArgumentException.class,
           () -> Area.surfaceAreaCone(-1.0, 5.0));
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

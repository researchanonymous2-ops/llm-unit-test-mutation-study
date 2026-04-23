package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaGrok_OS1Test {

   @Test
   void testSurfaceAreaCone_ValidInputs() {
       double result = Area.surfaceAreaCone(3.0, 4.0);
       assertEquals(Math.PI * 3.0 * (3.0 + Math.sqrt(16.0 + 9.0)), result);
   }

   @Test
   void testSurfaceAreaCone_AnotherValidInputs() {
       double result = Area.surfaceAreaCone(1.0, 1.0);
       assertEquals(Math.PI * 1.0 * (1.0 + Math.sqrt(1.0 + 1.0)), result);
   }

   @Test
   void testSurfaceAreaCone_DecimalInputs() {
       double result = Area.surfaceAreaCone(2.5, 3.5);
       assertEquals(Math.PI * 2.5 * (2.5 + Math.sqrt(12.25 + 6.25)), result);
   }

   @Test
   void testSurfaceAreaCone_ZeroRadius() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 5.0));
   }

   @Test
   void testSurfaceAreaCone_NegativeRadius() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, 5.0));
   }

   @Test
   void testSurfaceAreaCone_ZeroHeight() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, 0.0));
   }

   @Test
   void testSurfaceAreaCone_NegativeHeight() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -1.0));
   }
}

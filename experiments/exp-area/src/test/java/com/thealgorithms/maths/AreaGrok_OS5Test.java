package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.thealgorithms.maths.Area;

public class AreaGrok_OS5Test {

   @Test
   void testSurfaceAreaCone_ValidInputs() {
       double result = Area.surfaceAreaCone(3.0, 4.0);
       assertEquals(Math.PI * 3.0 * (3.0 + Math.sqrt(16.0 + 9.0)), result);
   }

   @Test
   void testSurfaceAreaCone_ValidInputsSmallValues() {
       double result = Area.surfaceAreaCone(0.5, 1.0);
       assertEquals(Math.PI * 0.5 * (0.5 + Math.sqrt(1.0 + 0.25)), result);
   }

   @Test
   void testSurfaceAreaCone_ValidInputsLargeValues() {
       double result = Area.surfaceAreaCone(10.0, 20.0);
       assertEquals(Math.PI * 10.0 * (10.0 + Math.sqrt(400.0 + 100.0)), result);
   }

   @Test
   void testSurfaceAreaCone_ZeroRadius() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 5.0));
   }

   @Test
   void testSurfaceAreaCone_NegativeRadius() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, 5.0));
   }

   @Test
   void testSurfaceAreaCone_ZeroHeight() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, 0));
   }

   @Test
   void testSurfaceAreaCone_NegativeHeight() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(3.0, -1.0));
   }

   @Test
   void testSurfaceAreaCone_BothZero() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 0));
   }

   @Test
   void testSurfaceAreaCone_BothNegative() {
       assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, -1.0));
   }
}

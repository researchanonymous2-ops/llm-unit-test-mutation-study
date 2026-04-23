package com.thealgorithms.maths;

package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AreaGrok_COC5Test {

   @Test
   void testSurfaceAreaCone_RadiusZero() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_RadiusNegative() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 1));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_HeightZero() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
       assertEquals("Must be a positive height", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_HeightNegative() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, -1));
       assertEquals("Must be a positive height", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_ValidInputs() {
       double radius = 1.0;
       double height = 1.0;
       double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
       assertEquals(expected, Area.surfaceAreaCone(radius, height));
   }
}

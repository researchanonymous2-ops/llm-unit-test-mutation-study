package com.thealgorithms.maths;

package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AreaGrok_COC1Test {

   @Test
   void testSurfaceAreaCone_NegativeRadius() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1.0, 1.0));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_ZeroRadius() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0.0, 1.0));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_NegativeHeight() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1.0, -1.0));
       assertEquals("Must be a positive height", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_ZeroHeight() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1.0, 0.0));
       assertEquals("Must be a positive height", exception.getMessage());
   }

   @Test
   void testSurfaceAreaCone_PositiveValues() {
       double radius = 3.0;
       double height = 4.0;
       double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
       assertEquals(expected, Area.surfaceAreaCone(radius, height), 1e-9);
   }
}

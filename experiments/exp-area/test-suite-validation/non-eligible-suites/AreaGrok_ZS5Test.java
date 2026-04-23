package com.thealgorithms.maths;

package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreaGrok_ZS5Test {

   @Test
   public void testSurfaceAreaCone_ValidInputs() {
       assertEquals(Math.PI * 1 * (1 + Math.sqrt(1 + 1)), Area.surfaceAreaCone(1, 1), 1e-9);
       assertEquals(Math.PI * 3 * (3 + Math.sqrt(16 + 9)), Area.surfaceAreaCone(3, 4), 1e-9);
       assertEquals(Math.PI * 2.5 * (2.5 + Math.sqrt(6.25 + 6.25)), Area.surfaceAreaCone(2.5, 2.5), 1e-9);
   }

   @Test
   public void testSurfaceAreaCone_InvalidRadiusZero() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 1));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   public void testSurfaceAreaCone_InvalidRadiusNegative() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, 1));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   public void testSurfaceAreaCone_InvalidHeightZero() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, 0));
       assertEquals("Must be a positive height", exception.getMessage());
   }

   @Test
   public void testSurfaceAreaCone_InvalidHeightNegative() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(1, -1));
       assertEquals("Must be a positive height", exception.getMessage());
   }

   @Test
   public void testSurfaceAreaCone_InvalidBothZero() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(0, 0));
       assertEquals("Must be a positive radius", exception.getMessage());
   }

   @Test
   public void testSurfaceAreaCone_InvalidBothNegative() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(-1, -1));
       assertEquals("Must be a positive radius", exception.getMessage());
   }
}

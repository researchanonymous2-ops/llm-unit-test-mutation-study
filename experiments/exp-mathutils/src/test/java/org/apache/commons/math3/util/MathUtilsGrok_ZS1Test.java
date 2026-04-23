package org.apache.commons.math3.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;

public class MathUtilsGrok_ZS1Test {

   @Test
   public void testCheckFinite_EmptyArray() {
       double[] val = new double[0];
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_AllFinite() {
       double[] val = new double[]{1.0, 2.0, 3.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithNaN() {
       double[] val = new double[]{1.0, Double.NaN, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithPositiveInfinity() {
       double[] val = new double[]{1.0, Double.POSITIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithNegativeInfinity() {
       double[] val = new double[]{1.0, Double.NEGATIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_NullArray() {
       assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(null));
   }
}

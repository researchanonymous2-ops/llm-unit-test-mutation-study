package org.apache.commons.math3.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;

public class MathUtilsGrok_ZS2Test {

   @Test
   public void testCheckFinite_EmptyArray() {
       double[] val = new double[0];
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_AllFinite() {
       double[] val = {1.0, 2.5, -3.7, 0.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithNaN() {
       double[] val = {1.0, Double.NaN, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithPositiveInfinity() {
       double[] val = {1.0, Double.POSITIVE_INFINITY, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithNegativeInfinity() {
       double[] val = {1.0, Double.NEGATIVE_INFINITY, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_WithMultipleInvalid() {
       double[] val = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_NullArray() {
       double[] val = null;
       assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(val));
   }
}

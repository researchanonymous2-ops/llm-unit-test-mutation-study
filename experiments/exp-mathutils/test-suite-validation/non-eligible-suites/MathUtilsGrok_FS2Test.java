package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_FS2Test {

   @Test
   void testCheckFinite_WithFiniteValues() {
       double[] values = {0.5, -1.2, 3.14};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNaN() {
       double[] values = {1.0, Double.NaN, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithPositiveInfinity() {
       double[] values = {Double.POSITIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNegativeInfinity() {
       double[] values = {Double.NEGATIVE_INFINITY, 1.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithEmptyArray() {
       double[] values = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithMultipleNonFinite() {
       double[] values = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }
}

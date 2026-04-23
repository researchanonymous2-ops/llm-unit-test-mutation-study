package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_FS1Test {

   @Test
   void testCheckFinite_WithFiniteValues() {
       double[] values = {0.0, -1.5, 2.3, 100.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNaNValue() {
       double[] values = {1.0, Double.NaN, 3.0};
       assertThrows(Exception.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithPositiveInfinity() {
       double[] values = {Double.POSITIVE_INFINITY, 2.0};
       assertThrows(Exception.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNegativeInfinity() {
       double[] values = {-5.0, Double.NEGATIVE_INFINITY};
       assertThrows(Exception.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithEmptyArray() {
       double[] values = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithSingleFiniteValue() {
       double[] values = {42.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithMultipleNonFiniteValues() {
       double[] values = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
       assertThrows(Exception.class, () -> MathUtils.checkFinite(values));
   }
}

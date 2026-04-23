package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_FS5Test {

   @Test
   void testCheckFinite_WithFiniteValues() {
       double[] values = {0.5, -1.2, 3.14};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNaNValue() {
       double[] values = {2.0, Double.NaN, 4.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithPositiveInfinity() {
       double[] values = {Double.POSITIVE_INFINITY, 1.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNegativeInfinity() {
       double[] values = {-5.0, Double.NEGATIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithEmptyArray() {
       double[] values = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithSingleFiniteValue() {
       double[] values = {7.89};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithSingleNaNValue() {
       double[] values = {Double.NaN};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }
}

package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_OS3Test {

   @Test
   void testCheckFinite_ValidArray() {
       double[] values = {3.14, -2.71, 0.0, 100.5};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_ArrayWithNaN() {
       double[] values = {1.0, Double.NaN, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_ArrayWithPositiveInfinity() {
       double[] values = {5.0, Double.POSITIVE_INFINITY, 7.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_ArrayWithNegativeInfinity() {
       double[] values = {10.0, Double.NEGATIVE_INFINITY, 15.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_EmptyArray() {
       double[] values = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_ArrayWithMixedValues() {
       double[] values = {4.0, Double.NaN, Double.POSITIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }
}

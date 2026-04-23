package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_OS4Test {

   @Test
   void testCheckFinite_ValidArray() {
       double[] values = {1.0, -2.5, 0.0, 3.14};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_EmptyArray() {
       double[] values = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNaN() {
       double[] values = {1.0, Double.NaN, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithPositiveInfinity() {
       double[] values = {1.0, Double.POSITIVE_INFINITY, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_WithNegativeInfinity() {
       double[] values = {1.0, Double.NEGATIVE_INFINITY, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_SingleNaN() {
       double[] values = {Double.NaN};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_SingleInfinity() {
       double[] values = {Double.POSITIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_MixedValidAndInvalid() {
       double[] values = {0.0, 1.5, Double.NaN, -3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }
}

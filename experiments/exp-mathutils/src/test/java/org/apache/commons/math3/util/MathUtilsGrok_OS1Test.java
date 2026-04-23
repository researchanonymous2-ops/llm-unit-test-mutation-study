package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.util.MathUtils;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_OS1Test {

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
   void testCheckFinite_ArrayWithNaN() {
       double[] values = {1.0, Double.NaN, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_ArrayWithPositiveInfinity() {
       double[] values = {1.0, Double.POSITIVE_INFINITY, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_ArrayWithNegativeInfinity() {
       double[] values = {1.0, Double.NEGATIVE_INFINITY, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_NullArray() {
       double[] values = null;
       assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(values));
   }
}

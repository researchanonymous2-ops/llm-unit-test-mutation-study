package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.junit.jupiter.api.Test;

public class MathUtilsGrok_OS2Test {

   @Test
   void testCheckFinite_ValidArray() {
       double[] values = {1.0, 2.0, 3.5};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_EmptyArray() {
       double[] values = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_PositiveInfinity() {
       double[] values = {1.0, Double.POSITIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_NegativeInfinity() {
       double[] values = {1.0, Double.NEGATIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_NaN() {
       double[] values = {1.0, Double.NaN, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_MultipleNonFinite() {
       double[] values = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(values));
   }

   @Test
   void testCheckFinite_NullArray() {
       double[] values = null;
       assertThrows(NullPointerException.class, () -> MathUtils.checkFinite(values));
   }
}

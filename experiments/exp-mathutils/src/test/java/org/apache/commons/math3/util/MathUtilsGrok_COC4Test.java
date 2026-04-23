package org.apache.commons.math3.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;

public class MathUtilsGrok_COC4Test {

   @Test
   void testCheckFinite_AllFinite() {
       double[] val = {1.0, 2.0, 3.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_EmptyArray() {
       double[] val = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_SingleFinite() {
       double[] val = {5.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_WithNaN() {
       double[] val = {1.0, Double.NaN, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_WithPositiveInfinity() {
       double[] val = {1.0, Double.POSITIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_WithNegativeInfinity() {
       double[] val = {1.0, Double.NEGATIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_FirstElementNaN() {
       double[] val = {Double.NaN, 1.0, 2.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   void testCheckFinite_LastElementInfinity() {
       double[] val = {1.0, 2.0, Double.POSITIVE_INFINITY};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }
}

package org.apache.commons.math3.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.exception.NotFiniteNumberException;

public class MathUtilsGrok_COC2Test {

   @Test
   public void testCheckFinite_AllFinite() {
       double[] val = {1.0, 2.0, 3.0};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_EmptyArray() {
       double[] val = {};
       assertDoesNotThrow(() -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_ContainsNaN() {
       double[] val = {1.0, Double.NaN, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_ContainsPositiveInfinity() {
       double[] val = {1.0, Double.POSITIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }

   @Test
   public void testCheckFinite_ContainsNegativeInfinity() {
       double[] val = {1.0, Double.NEGATIVE_INFINITY, 3.0};
       assertThrows(NotFiniteNumberException.class, () -> MathUtils.checkFinite(val));
   }
}

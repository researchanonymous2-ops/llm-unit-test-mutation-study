package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.Range;

public class RangeGrok_POT1Test {

   @Test
   void testElementCompareTo_NullElement() {
       Range<Integer> range = Range.between(1, 10);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   void testElementCompareTo_ElementBeforeRange() {
       Range<Integer> range = Range.between(5, 10);
       assertEquals(-1, range.elementCompareTo(3));
   }

   @Test
   void testElementCompareTo_ElementAfterRange() {
       Range<Integer> range = Range.between(5, 10);
       assertEquals(1, range.elementCompareTo(15));
   }

   @Test
   void testElementCompareTo_ElementWithinRange() {
       Range<Integer> range = Range.between(5, 10);
       assertEquals(0, range.elementCompareTo(7));
   }

   @Test
   void testElementCompareTo_ElementAtMinimum() {
       Range<Integer> range = Range.between(5, 10);
       assertEquals(0, range.elementCompareTo(5));
   }

   @Test
   void testElementCompareTo_ElementAtMaximum() {
       Range<Integer> range = Range.between(5, 10);
       assertEquals(0, range.elementCompareTo(10));
   }
}

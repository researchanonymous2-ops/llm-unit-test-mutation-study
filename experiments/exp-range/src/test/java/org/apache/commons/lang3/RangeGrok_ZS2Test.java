package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.Range;

public class RangeGrok_ZS2Test {

   @Test
   public void testElementCompareTo_NullElement() {
       Range<Integer> range = Range.between(1, 5);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   public void testElementCompareTo_ElementBeforeRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(-1, range.elementCompareTo(0));
   }

   @Test
   public void testElementCompareTo_ElementAtMinimum() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(1));
   }

   @Test
   public void testElementCompareTo_ElementWithinRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(3));
   }

   @Test
   public void testElementCompareTo_ElementAtMaximum() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(5));
   }

   @Test
   public void testElementCompareTo_ElementAfterRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(1, range.elementCompareTo(6));
   }

   @Test
   public void testElementCompareTo_SingleElementRange_ElementBefore() {
       Range<Integer> range = Range.is(5);
       assertEquals(-1, range.elementCompareTo(4));
   }

   @Test
   public void testElementCompareTo_SingleElementRange_ElementEqual() {
       Range<Integer> range = Range.is(5);
       assertEquals(0, range.elementCompareTo(5));
   }

   @Test
   public void testElementCompareTo_SingleElementRange_ElementAfter() {
       Range<Integer> range = Range.is(5);
       assertEquals(1, range.elementCompareTo(6));
   }
}

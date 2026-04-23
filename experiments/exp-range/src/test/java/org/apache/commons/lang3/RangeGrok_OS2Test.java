package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_OS2Test {

   @Test
   void testElementCompareTo_NullElement() {
       Range<Integer> range = Range.between(1, 5);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   void testElementCompareTo_ElementBeforeRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(-1, range.elementCompareTo(0));
   }

   @Test
   void testElementCompareTo_ElementAtMinimum() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(1));
   }

   @Test
   void testElementCompareTo_ElementInsideRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(3));
   }

   @Test
   void testElementCompareTo_ElementAtMaximum() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(5));
   }

   @Test
   void testElementCompareTo_ElementAfterRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(1, range.elementCompareTo(6));
   }

   @Test
   void testElementCompareTo_SingleElementRange() {
       Range<Integer> range = Range.is(3);
       assertEquals(0, range.elementCompareTo(3));
       assertEquals(-1, range.elementCompareTo(2));
       assertEquals(1, range.elementCompareTo(4));
   }

   @Test
   void testElementCompareTo_StringRange() {
       Range<String> range = Range.between("a", "c");
       assertEquals(-1, range.elementCompareTo(""));
       assertEquals(0, range.elementCompareTo("a"));
       assertEquals(0, range.elementCompareTo("b"));
       assertEquals(0, range.elementCompareTo("c"));
       assertEquals(1, range.elementCompareTo("d"));
   }
}

package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_FS1Test {

   @Test
   void testElementCompareTo_InsideRange() {
       Range<Integer> range = Range.between(10, 20);
       assertEquals(0, range.elementCompareTo(15));
   }

   @Test
   void testElementCompareTo_BeforeRange() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(-1, range.elementCompareTo(2));
   }

   @Test
   void testElementCompareTo_AfterRange() {
       Range<Integer> range = Range.between(7, 12);
       assertEquals(1, range.elementCompareTo(18));
   }

   @Test
   void testElementCompareTo_AtMinimum() {
       Range<Integer> range = Range.between(4, 9);
       assertEquals(0, range.elementCompareTo(4));
   }

   @Test
   void testElementCompareTo_AtMaximum() {
       Range<Integer> range = Range.between(6, 14);
       assertEquals(0, range.elementCompareTo(14));
   }

   @Test
   void testElementCompareTo_SingleElementRange() {
       Range<Integer> range = Range.is(8);
       assertEquals(0, range.elementCompareTo(8));
       assertEquals(-1, range.elementCompareTo(5));
       assertEquals(1, range.elementCompareTo(12));
   }

   @Test
   void testElementCompareTo_NullElement() {
       Range<Integer> range = Range.between(1, 5);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   void testElementCompareTo_WithStringRange() {
       Range<String> range = Range.between("apple", "zebra");
       assertEquals(0, range.elementCompareTo("banana"));
       assertEquals(-1, range.elementCompareTo("aardvark"));
       assertEquals(1, range.elementCompareTo("zoo"));
   }
}

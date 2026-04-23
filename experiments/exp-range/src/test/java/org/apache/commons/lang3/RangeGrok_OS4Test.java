package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_OS4Test {

   @Test
   void testElementCompareTo_NullElement() {
       Range<Integer> range = Range.between(1, 5);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   void testElementCompareTo_BeforeRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(-1, range.elementCompareTo(0));
   }

   @Test
   void testElementCompareTo_AtMinimum() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(1));
   }

   @Test
   void testElementCompareTo_InsideRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(3));
   }

   @Test
   void testElementCompareTo_AtMaximum() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(0, range.elementCompareTo(5));
   }

   @Test
   void testElementCompareTo_AfterRange() {
       Range<Integer> range = Range.between(1, 5);
       assertEquals(1, range.elementCompareTo(6));
   }

   @Test
   void testElementCompareTo_SingleElementRange() {
       Range<Integer> range = Range.is(3);
       assertEquals(-1, range.elementCompareTo(2));
       assertEquals(0, range.elementCompareTo(3));
       assertEquals(1, range.elementCompareTo(4));
   }

   @Test
   void testElementCompareTo_StringRange() {
       Range<String> range = Range.between("a", "z");
       assertEquals(-1, range.elementCompareTo("A"));
       assertEquals(0, range.elementCompareTo("m"));
       assertEquals(1, range.elementCompareTo("zz"));
   }

   @Test
   void testElementCompareTo_CustomComparator() {
       Comparator<Integer> reverseComparator = Comparator.reverseOrder();
       Range<Integer> range = Range.between(5, 1, reverseComparator);
       assertEquals(-1, range.elementCompareTo(6));
       assertEquals(0, range.elementCompareTo(3));
       assertEquals(1, range.elementCompareTo(0));
   }
}

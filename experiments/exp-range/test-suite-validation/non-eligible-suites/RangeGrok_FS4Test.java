package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_FS4Test {

   @Test
   void testElementCompareTo_NullElement() {
       Range<Integer> range = Range.between(1, 10);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   void testElementCompareTo_BeforeRange() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(-1, range.elementCompareTo(3));
   }

   @Test
   void testElementCompareTo_AtMinimum() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(0, range.elementCompareTo(5));
   }

   @Test
   void testElementCompareTo_InsideRange() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(0, range.elementCompareTo(10));
   }

   @Test
   void testElementCompareTo_AtMaximum() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(0, range.elementCompareTo(15));
   }

   @Test
   void testElementCompareTo_AfterRange() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(1, range.elementCompareTo(20));
   }

   @Test
   void testElementCompareTo_WithString() {
       Range<String> range = Range.between("apple", "zebra");
       assertEquals(-1, range.elementCompareTo("banana"));
       assertEquals(0, range.elementCompareTo("mango"));
       assertEquals(1, range.elementCompareTo("zoo"));
   }

   @Test
   void testElementCompareTo_WithCustomComparator() {
       Comparator<Integer> reverseComparator = Comparator.reverseOrder();
       Range<Integer> range = Range.between(15, 5, reverseComparator);
       assertEquals(-1, range.elementCompareTo(20));
       assertEquals(0, range.elementCompareTo(10));
       assertEquals(1, range.elementCompareTo(1));
   }

   @Test
   void testElementCompareTo_SingleElementRange() {
       Range<Double> range = Range.is(5.0);
       assertEquals(-1, range.elementCompareTo(4.0));
       assertEquals(0, range.elementCompareTo(5.0));
       assertEquals(1, range.elementCompareTo(6.0));
   }
}

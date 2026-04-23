package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeQwen_FS4Test {

   @Test
   void testElementCompareTo_elementBeforeRange_returnsMinusOne() {
       Range<Integer> range = Range.between(5, 15);
       assertEquals(-1, range.elementCompareTo(3));
   }

   @Test
   void testElementCompareTo_elementAfterRange_returnsOne() {
       Range<String> range = Range.between("b", "e");
       assertEquals(1, range.elementCompareTo("g"));
   }

   @Test
   void testElementCompareTo_elementInsideRange_returnsZero() {
       Range<Double> range = Range.between(1.5, 7.8);
       assertEquals(0, range.elementCompareTo(4.2));
   }

   @Test
   void testElementCompareTo_elementEqualToMinimum_returnsZero() {
       Range<Character> range = Range.between('a', 'z');
       assertEquals(0, range.elementCompareTo('a'));
   }

   @Test
   void testElementCompareTo_elementEqualToMaximum_returnsZero() {
       Range<Long> range = Range.between(100L, 200L);
       assertEquals(0, range.elementCompareTo(200L));
   }

   @Test
   void testElementCompareTo_elementJustBeforeRange_returnsMinusOne() {
       Range<Integer> range = Range.between(10, 20);
       assertEquals(-1, range.elementCompareTo(9));
   }

   @Test
   void testElementCompareTo_elementJustAfterRange_returnsOne() {
       Range<Integer> range = Range.between(10, 20);
       assertEquals(1, range.elementCompareTo(21));
   }

   @Test
   void testElementCompareTo_nullElement_throwsNullPointerException() {
       Range<Integer> range = Range.between(1, 10);
       assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
   }

   @Test
   void testElementCompareTo_withCustomComparator_elementBeforeRange_returnsMinusOne() {
       Range<String> range = Range.between("apple", "zebra", String.CASE_INSENSITIVE_ORDER);
       assertEquals(-1, range.elementCompareTo("ABC"));
   }

   @Test
   void testElementCompareTo_withCustomComparator_elementAfterRange_returnsOne() {
       Range<String> range = Range.between("apple", "zebra", String.CASE_INSENSITIVE_ORDER);
       assertEquals(1, range.elementCompareTo("ZOO"));
   }

   @Test
   void testElementCompareTo_withCustomComparator_elementInsideRange_returnsZero() {
       Range<String> range = Range.between("apple", "zebra", String.CASE_INSENSITIVE_ORDER);
       assertEquals(0, range.elementCompareTo("Banana"));
   }
}

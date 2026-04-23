package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_OS3Test {

   @Test
   void testContains_nullRange_throwsException() {
       CharRange range = CharRange.is('a');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_rangeWithin() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_rangeOutside() {
       CharRange outer = CharRange.isIn('a', 'e');
       CharRange inner = CharRange.isIn('f', 'j');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_partialOverlap() {
       CharRange outer = CharRange.isIn('a', 'e');
       CharRange inner = CharRange.isIn('d', 'h');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_sameRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_singleCharWithin() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.is('m');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_singleCharOutside() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.is('0');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_completelyExcluded() {
       CharRange outer = CharRange.isNotIn('f', 'k');
       CharRange inner = CharRange.isIn('a', 'e');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_partiallyOverlaps() {
       CharRange outer = CharRange.isNotIn('f', 'k');
       CharRange inner = CharRange.isIn('e', 'g');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_fullyContained() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_singleCharExcluded() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_singleCharIncluded() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('x');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNegated_fullRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNegated_notFullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNegated_singleCharExcluded() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNot('m');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_innerNegationLarger() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'h');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_innerNegationSame() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_innerNegationSmaller() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('d', 'm');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_singleCharExcludedInBoth() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.isNot('y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_singleCharSameExclusion() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.isNot('x');
       assertTrue(outer.contains(inner));
   }
}

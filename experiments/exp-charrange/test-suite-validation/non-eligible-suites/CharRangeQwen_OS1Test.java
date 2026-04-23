package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_OS1Test {

   @Test
   void testContains_nullRange_throwsException() {
       CharRange range = CharRange.is('a');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_nonNegatedRangeContainsNonNegatedRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeDoesNotContainNonNegatedRange() {
       CharRange outer = CharRange.isIn('a', 'd');
       CharRange inner = CharRange.isIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNegatedRange() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNegatedRange() {
       CharRange outer = CharRange.isNotIn('a', 'd');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeContainsNegatedRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeDoesNotContainNegatedRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNonNegatedRange() {
       CharRange outer = CharRange.isNotIn('x', 'z');
       CharRange inner = CharRange.isIn('a', 'd');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNonNegatedRange() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isIn('d', 'g');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_equalNonNegatedRanges() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_equalNegatedRanges() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNonNegatedRange() {
       CharRange outer = CharRange.is('m');
       CharRange inner = CharRange.is('m');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNegatedRange() {
       CharRange outer = CharRange.isNot('m');
       CharRange inner = CharRange.isNot('m');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_edgeCaseFullRangeNegated() {
       CharRange outer = CharRange.isNotIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_edgeCaseFullRangeNonNegated() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }
}

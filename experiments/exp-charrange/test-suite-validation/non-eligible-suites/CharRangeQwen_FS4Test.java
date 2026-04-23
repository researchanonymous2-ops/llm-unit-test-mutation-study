package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_FS4Test {

   @Test
   void testContains_nullRange_throwsException() {
       CharRange range = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_nonNegatedRangeContainsNonNegatedRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'x');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeDoesNotContainNonNegatedRange() {
       CharRange outer = CharRange.isIn('c', 'x');
       CharRange inner = CharRange.isIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeContainsSingleCharNonNegatedRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.is('m');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeDoesNotContainSingleCharNonNegatedRange() {
       CharRange outer = CharRange.isIn('b', 'y');
       CharRange inner = CharRange.is('a');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNegatedRange() {
       CharRange outer = CharRange.isNotIn('d', 'w');
       CharRange inner = CharRange.isNotIn('e', 'v');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNegatedRange() {
       CharRange outer = CharRange.isNotIn('e', 'v');
       CharRange inner = CharRange.isNotIn('d', 'w');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsSingleCharNegatedRange() {
       CharRange outer = CharRange.isNotIn('b', 'y');
       CharRange inner = CharRange.isNot('m');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainSingleCharNegatedRange() {
       CharRange outer = CharRange.isNotIn('c', 'x');
       CharRange inner = CharRange.isNot('b');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeContainsNegatedRange_fullRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeDoesNotContainNegatedRange_notFullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNonNegatedRange_disjointAtStart() {
       CharRange outer = CharRange.isNotIn('g', 't');
       CharRange inner = CharRange.isIn('a', 'd');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNonNegatedRange_disjointAtEnd() {
       CharRange outer = CharRange.isNotIn('g', 't');
       CharRange inner = CharRange.isIn('w', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNonNegatedRange_overlapping() {
       CharRange outer = CharRange.isNotIn('g', 't');
       CharRange inner = CharRange.isIn('d', 'k');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNonNegatedRange_subset() {
       CharRange outer = CharRange.isNotIn('g', 't');
       CharRange inner = CharRange.isIn('h', 's');
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
   void testContains_singleCharNonNegatedRangeInSingleCharNonNegatedRange() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNonNegatedRangeDoesNotContainDifferentSingleCharNonNegatedRange() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('b');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNegatedRangeInSingleCharNegatedRange() {
       CharRange outer = CharRange.isNot('a');
       CharRange inner = CharRange.isNot('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNegatedRangeDoesNotContainDifferentSingleCharNegatedRange() {
       CharRange outer = CharRange.isNot('a');
       CharRange inner = CharRange.isNot('b');
       assertFalse(outer.contains(inner));
   }
}

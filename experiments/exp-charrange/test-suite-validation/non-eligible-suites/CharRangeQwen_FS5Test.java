package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_FS5Test {

   @Test
   void testContains_nullRange_throwsException() {
       CharRange range = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_nonNegatedOuter_containsNonNegatedInner_completelyInside() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('d', 'm');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedOuter_containsNonNegatedInner_partialOverlap_start() {
       CharRange outer = CharRange.isIn('d', 'm');
       CharRange inner = CharRange.isIn('a', 'e');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedOuter_containsNonNegatedInner_partialOverlap_end() {
       CharRange outer = CharRange.isIn('d', 'm');
       CharRange inner = CharRange.isIn('k', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedOuter_containsNonNegatedInner_outside() {
       CharRange outer = CharRange.isIn('d', 'm');
       CharRange inner = CharRange.isIn('p', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedOuter_containsNegatedInner_singleChar() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNot('c');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedOuter_containsNegatedInner_fullRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedOuter_containsNonNegatedInner_noOverlap() {
       CharRange outer = CharRange.isNotIn('g', 's');
       CharRange inner = CharRange.isIn('a', 'd');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedOuter_containsNonNegatedInner_overlaps() {
       CharRange outer = CharRange.isNotIn('g', 's');
       CharRange inner = CharRange.isIn('m', 'u');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedOuter_containsNegatedInner_superset() {
       CharRange outer = CharRange.isNotIn('c', 'm');
       CharRange inner = CharRange.isNotIn('d', 'k');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedOuter_containsNegatedInner_notSuperset() {
       CharRange outer = CharRange.isNotIn('d', 'k');
       CharRange inner = CharRange.isNotIn('c', 'm');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedSingleChar_containsNonNegatedSingleChar_same() {
       CharRange outer = CharRange.is('x');
       CharRange inner = CharRange.is('x');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedSingleChar_containsNonNegatedSingleChar_different() {
       CharRange outer = CharRange.is('x');
       CharRange inner = CharRange.is('y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedSingleChar_containsNonNegatedSingleChar_excluded() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('x');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedSingleChar_containsNonNegatedSingleChar_included() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedSingleChar_containsNegatedSingleChar_same() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.isNot('x');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedSingleChar_containsNegatedSingleChar_different() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.isNot('y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedFullRange_containsNegatedAnyRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedLessThanFullRange_containsNegatedAnyRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedOuterEdgeCase_startZero_containsNonNegatedInner() {
       CharRange outer = CharRange.isNotIn((char) 0, 'a');
       CharRange inner = CharRange.isIn('b', 'd');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedOuterEdgeCase_endMaxValue_containsNonNegatedInner() {
       CharRange outer = CharRange.isNotIn('z', Character.MAX_VALUE);
       CharRange inner = CharRange.isIn('a', 'x');
       assertTrue(outer.contains(inner));
   }
}

package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_OS5Test {

   @Test
   void testContains_NullRange() {
       CharRange range = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_EqualNonNegatedRanges() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SubsetNonNegatedRanges() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_PartialOverlapNonNegatedRanges() {
       CharRange outer = CharRange.isIn('a', 'm');
       CharRange inner = CharRange.isIn('k', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NoOverlapNonNegatedRanges() {
       CharRange outer = CharRange.isIn('a', 'm');
       CharRange inner = CharRange.isIn('n', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharNonNegated() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.is('c');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedRangeInNonNegated() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_FullRangeNonNegatedContainsNegated() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonFullRangeNonNegatedContainsNegated() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_EqualNegatedRanges() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SubsetNegatedRanges() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SupersetNegatedRanges() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegated() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegatedOutside() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('0', '9');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegatedInside() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharNegated() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.is('c');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharNegatedOutside() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.is('!');
       assertTrue(outer.contains(inner));
   }
}

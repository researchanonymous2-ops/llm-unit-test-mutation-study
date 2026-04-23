package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_FS3Test {

   @Test
   void testContains_nullRange_throwsException() {
       CharRange range = CharRange.isIn('a', 'z');
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
   void testContains_nonNegatedRangeContainsNegatedRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedRangeDoesNotContainNegatedRange() {
       CharRange outer = CharRange.isIn('b', 'y');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNonNegatedRange() {
       CharRange outer = CharRange.isNotIn('m', 'p');
       CharRange inner = CharRange.isIn('a', 'c');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNonNegatedRange() {
       CharRange outer = CharRange.isNotIn('a', 'd');
       CharRange inner = CharRange.isIn('b', 'c');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeContainsNegatedRange() {
       CharRange outer = CharRange.isNotIn('a', 'd');
       CharRange inner = CharRange.isNotIn('b', 'c');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedRangeDoesNotContainNegatedRange() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'd');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNonNegatedRangeContainsSingleCharNonNegatedRange() {
       CharRange outer = CharRange.is('x');
       CharRange inner = CharRange.is('x');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNonNegatedRangeDoesNotContainSingleCharNonNegatedRange() {
       CharRange outer = CharRange.is('x');
       CharRange inner = CharRange.is('y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNegatedRangeDoesNotContainFullRangeNegated() {
       CharRange outer = CharRange.isNot('a');
       CharRange inner = CharRange.isNotIn((char) 0, Character.MAX_VALUE);
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_fullRangeNegatedContainedInSingleCharNegated() {
       CharRange outer = CharRange.isNotIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNot('a');
       assertTrue(outer.contains(inner));
   }
}

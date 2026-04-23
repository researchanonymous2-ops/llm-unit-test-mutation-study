package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_OS2Test {

   @Test
   void testContains_NullRange() {
       CharRange range = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_True() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_False() {
       CharRange outer = CharRange.isIn('a', 'f');
       CharRange inner = CharRange.isIn('c', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_Equal() {
       CharRange range1 = CharRange.isIn('a', 'z');
       CharRange range2 = CharRange.isIn('a', 'z');
       assertTrue(range1.contains(range2));
   }

   @Test
   void testContains_NonNegatedContainsNegated_True() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegated_False() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegated_True() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('A', 'Z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegated_False() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegated_True() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegated_False() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharContainsSingleChar() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharDoesNotContainDifferent() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('b');
       assertFalse(outer.contains(inner));
   }
}

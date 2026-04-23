package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_FS4Test {

   @Test
   void testContains_NullRangeThrowsException() {
       CharRange outer = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_True() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_False_StartBefore() {
       CharRange outer = CharRange.isIn('b', 'z');
       CharRange inner = CharRange.isIn('a', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_False_EndAfter() {
       CharRange outer = CharRange.isIn('a', 'y');
       CharRange inner = CharRange.isIn('b', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_EqualRanges() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegated_FullRange() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegated_NotFullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegated_True() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegated_False_StartAfter() {
       CharRange outer = CharRange.isNotIn('b', 'z');
       CharRange inner = CharRange.isNotIn('a', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegated_False_EndBefore() {
       CharRange outer = CharRange.isNotIn('a', 'y');
       CharRange inner = CharRange.isNotIn('b', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegated_True() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('0', '9');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegated_False_Overlaps() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharNonNegatedContainsSingleChar() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharNegatedContainsSingleChar() {
       CharRange outer = CharRange.isNot('a');
       CharRange inner = CharRange.is('b');
       assertTrue(outer.contains(inner));
   }
}

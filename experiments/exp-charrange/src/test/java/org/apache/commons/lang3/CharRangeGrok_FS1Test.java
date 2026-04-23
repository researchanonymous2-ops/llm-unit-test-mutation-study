package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_FS1Test {

   @Test
   void testContains_NullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
   }

   @Test
   void testContains_NonNegatedContainsNonNegatedTrue() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegatedFalse() {
       CharRange outer = CharRange.isIn('a', 'm');
       CharRange inner = CharRange.isIn('n', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegatedTrue() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegatedFalse() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegatedTrue() {
       CharRange outer = CharRange.isNotIn('b', 'y');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegatedFalse() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegatedTrue() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('0', '9');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegatedFalse() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertFalse(outer.contains(inner));
   }
}

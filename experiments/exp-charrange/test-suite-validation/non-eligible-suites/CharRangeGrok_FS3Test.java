package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_FS3Test {

   @Test
   void testContains_NullRangeThrowsException() {
       CharRange outer = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedDoesNotContainNonNegated() {
       CharRange outer = CharRange.isIn('a', 'm');
       CharRange inner = CharRange.isIn('n', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsSingleChar() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.is('x');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedDoesNotContainSingleChar() {
       CharRange outer = CharRange.isIn('a', 'm');
       CharRange inner = CharRange.is('z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegated() {
       CharRange outer = CharRange.isNotIn('m', 'p');
       CharRange inner = CharRange.isNotIn('n', 'o');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedDoesNotContainNegated() {
       CharRange outer = CharRange.isNotIn('a', 'c');
       CharRange inner = CharRange.isNotIn('b', 'd');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegated() {
       CharRange outer = CharRange.isNotIn('x', 'z');
       CharRange inner = CharRange.isIn('a', 'w');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedDoesNotContainNonNegated() {
       CharRange outer = CharRange.isNotIn('a', 'm');
       CharRange inner = CharRange.isIn('b', 'l');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegatedFullRange() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedDoesNotContainNegatedPartialRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_EqualRanges() {
       CharRange range1 = CharRange.isIn('a', 'z');
       CharRange range2 = CharRange.isIn('a', 'z');
       assertTrue(range1.contains(range2));
   }

   @Test
   void testContains_SingleCharNegated() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharNegatedDoesNotContain() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('x');
       assertFalse(outer.contains(inner));
   }
}

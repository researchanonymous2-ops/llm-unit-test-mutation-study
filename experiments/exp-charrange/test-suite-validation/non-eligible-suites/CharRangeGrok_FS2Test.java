package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_FS2Test {

   @Test
   void testContains_NullRangeThrowsException() {
       CharRange outer = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
   }

   @Test
   void testContains_NonNegatedContainsNonNegatedInner() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedDoesNotContainNonNegatedOuter() {
       CharRange outer = CharRange.isIn('b', 'y');
       CharRange inner = CharRange.isIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNonNegatedEqual() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedDoesNotContainNonNegatedOverlapping() {
       CharRange outer = CharRange.isIn('a', 'm');
       CharRange inner = CharRange.isIn('k', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedContainsNegatedOnlyIfFullRange() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NonNegatedDoesNotContainNegatedIfNotFullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegatedInner() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('b', 'y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedDoesNotContainNegatedOuter() {
       CharRange outer = CharRange.isNotIn('b', 'y');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNegatedEqual() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedContainsNonNegatedOutside() {
       CharRange outer = CharRange.isNotIn('m', 'p');
       CharRange inner = CharRange.isIn('a', 'c');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedDoesNotContainNonNegatedInside() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('b', 'y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedDoesNotContainNonNegatedOverlapping() {
       CharRange outer = CharRange.isNotIn('a', 'm');
       CharRange inner = CharRange.isIn('k', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharContainsSingleChar() {
       CharRange outer = CharRange.is('x');
       CharRange inner = CharRange.is('x');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_SingleCharDoesNotContainDifferentSingleChar() {
       CharRange outer = CharRange.is('x');
       CharRange inner = CharRange.is('y');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_NegatedSingleCharContainsNonNegatedOutside() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('y');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_NegatedSingleCharDoesNotContainSameSingleChar() {
       CharRange outer = CharRange.isNot('x');
       CharRange inner = CharRange.is('x');
       assertFalse(outer.contains(inner));
   }
}

package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_OS4Test {

   @Test
   void testContains_nullRange() {
       CharRange range = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_EntirelyContained() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_PartiallyOverlapping() {
       CharRange outer = CharRange.isIn('a', 'f');
       CharRange inner = CharRange.isIn('d', 'k');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_NotOverlapping() {
       CharRange outer = CharRange.isIn('a', 'f');
       CharRange inner = CharRange.isIn('h', 'k');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_EqualRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNonNegated_InnerWiderThanOuter() {
       CharRange outer = CharRange.isIn('d', 'f');
       CharRange inner = CharRange.isIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_EntirelyContained() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_PartiallyOverlapping() {
       CharRange outer = CharRange.isNotIn('a', 'f');
       CharRange inner = CharRange.isNotIn('d', 'k');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_NotOverlapping() {
       CharRange outer = CharRange.isNotIn('a', 'f');
       CharRange inner = CharRange.isNotIn('h', 'k');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_EqualRange() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNegated_InnerWiderThanOuter() {
       CharRange outer = CharRange.isNotIn('d', 'f');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNegated_MinToMaxRange() {
       CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_nonNegatedContainsNegated_NotFullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_NoOverlap() {
       CharRange outer = CharRange.isNotIn('a', 'f');
       CharRange inner = CharRange.isIn('h', 'k');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_Overlap() {
       CharRange outer = CharRange.isNotIn('a', 'f');
       CharRange inner = CharRange.isIn('d', 'k');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_EntirelyContained() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_EdgeCaseStartOverlap() {
       CharRange outer = CharRange.isNotIn('a', 'f');
       CharRange inner = CharRange.isIn('a', 'c');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_negatedContainsNonNegated_EdgeCaseEndOverlap() {
       CharRange outer = CharRange.isNotIn('a', 'f');
       CharRange inner = CharRange.isIn('e', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNonNegatedContainsSingleCharNonNegated_SameChar() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNonNegatedContainsSingleCharNonNegated_DifferentChar() {
       CharRange outer = CharRange.is('a');
       CharRange inner = CharRange.is('b');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNegatedContainsSingleCharNegated_SameChar() {
       CharRange outer = CharRange.isNot('a');
       CharRange inner = CharRange.isNot('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_singleCharNegatedContainsSingleCharNegated_DifferentChar() {
       CharRange outer = CharRange.isNot('a');
       CharRange inner = CharRange.isNot('b');
       assertFalse(outer.contains(inner));
   }
}

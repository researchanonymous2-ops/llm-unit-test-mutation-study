package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_ZS3Test {

   @Test
   void testContains_NullRange() {
       CharRange range = CharRange.is('a');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_True() {
       CharRange range = CharRange.isIn('a', 'z');
       CharRange subRange = CharRange.isIn('b', 'y');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_False() {
       CharRange range = CharRange.isIn('a', 'z');
       CharRange subRange = CharRange.isIn('0', '9');
       assertFalse(range.contains(subRange));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_Equal() {
       CharRange range = CharRange.isIn('a', 'z');
       CharRange subRange = CharRange.isIn('a', 'z');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_SingleChar() {
       CharRange range = CharRange.isIn('a', 'z');
       CharRange subRange = CharRange.is('b');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NonNegatedContainsNegated_True() {
       CharRange range = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange subRange = CharRange.isNotIn('a', 'z');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NonNegatedContainsNegated_False() {
       CharRange range = CharRange.isIn('a', 'z');
       CharRange subRange = CharRange.isNotIn('a', 'z');
       assertFalse(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNonNegated_True() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.isIn('0', '9');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNonNegated_False() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.isIn('b', 'y');
       assertFalse(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNegated_True() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.isNotIn('b', 'y');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNegated_False() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.isNotIn('0', '9');
       assertFalse(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNegated_Equal() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.isNotIn('a', 'z');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNegated_SingleChar() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.isNot('b');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NegatedContainsNonNegated_SingleChar() {
       CharRange range = CharRange.isNotIn('a', 'z');
       CharRange subRange = CharRange.is('0');
       assertTrue(range.contains(subRange));
   }

   @Test
   void testContains_NonNegatedContainsNegated_SingleChar() {
       CharRange range = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange subRange = CharRange.isNot('a');
       assertTrue(range.contains(subRange));
   }
}

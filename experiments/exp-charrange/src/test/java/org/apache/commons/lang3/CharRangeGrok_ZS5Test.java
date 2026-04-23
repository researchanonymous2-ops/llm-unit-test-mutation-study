package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_ZS5Test {

   @Test
   void testContains_NullRange() {
       CharRange range = CharRange.is('a');
       assertThrows(IllegalArgumentException.class, () -> range.contains(null));
   }

   @Test
   void testContains_NegatedContainsNegated_True() {
       CharRange thisRange = CharRange.isNotIn('b', 'd');
       CharRange otherRange = CharRange.isNotIn('a', 'e');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NegatedContainsNegated_False() {
       CharRange thisRange = CharRange.isNotIn('a', 'e');
       CharRange otherRange = CharRange.isNotIn('b', 'd');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NegatedContainsNonNegated_True() {
       CharRange thisRange = CharRange.isNotIn('a', 'z');
       CharRange otherRange = CharRange.isIn('A', 'Z');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NegatedContainsNonNegated_False() {
       CharRange thisRange = CharRange.isNotIn('a', 'z');
       CharRange otherRange = CharRange.isIn('m', 'p');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NonNegatedContainsNegated_True() {
       CharRange thisRange = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange otherRange = CharRange.isNot('a');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NonNegatedContainsNegated_False() {
       CharRange thisRange = CharRange.isIn('a', 'z');
       CharRange otherRange = CharRange.isNot('a');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_True() {
       CharRange thisRange = CharRange.isIn('a', 'z');
       CharRange otherRange = CharRange.isIn('m', 'p');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NonNegatedContainsNonNegated_False() {
       CharRange thisRange = CharRange.isIn('a', 'z');
       CharRange otherRange = CharRange.isIn('A', 'Z');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_SingleCharContainsSingleChar_True() {
       CharRange thisRange = CharRange.is('a');
       CharRange otherRange = CharRange.is('a');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_SingleCharContainsSingleChar_False() {
       CharRange thisRange = CharRange.is('a');
       CharRange otherRange = CharRange.is('b');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NegatedSingleContainsNegatedSingle_True() {
       CharRange thisRange = CharRange.isNot('a');
       CharRange otherRange = CharRange.isNot('a');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_NegatedSingleContainsNegatedSingle_False() {
       CharRange thisRange = CharRange.isNot('a');
       CharRange otherRange = CharRange.isNot('b');
       assertFalse(thisRange.contains(otherRange));
   }
}

package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_COC3Test {

   @Test
   void testContains_NullRange() {
       CharRange charRange = CharRange.is('a');
       assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
   }

   @Test
   void testContains_BothNegated_True() {
       CharRange thisRange = CharRange.isNotIn('b', 'd');
       CharRange otherRange = CharRange.isNotIn('a', 'e');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_BothNegated_False() {
       CharRange thisRange = CharRange.isNotIn('a', 'c');
       CharRange otherRange = CharRange.isNotIn('b', 'd');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_ThisNegated_OtherNot_True() {
       CharRange thisRange = CharRange.isNotIn('a', 'z');
       CharRange otherRange = CharRange.isIn('A', 'Z');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_ThisNegated_OtherNot_False() {
       CharRange thisRange = CharRange.isNotIn('a', 'z');
       CharRange otherRange = CharRange.isIn('m', 'n');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_ThisNot_OtherNegated_True() {
       CharRange thisRange = CharRange.isIn((char) 0, Character.MAX_VALUE);
       CharRange otherRange = CharRange.isNot('x');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_ThisNot_OtherNegated_False() {
       CharRange thisRange = CharRange.isIn('a', 'z');
       CharRange otherRange = CharRange.isNot('x');
       assertFalse(thisRange.contains(otherRange));
   }

   @Test
   void testContains_BothNot_True() {
       CharRange thisRange = CharRange.isIn('a', 'z');
       CharRange otherRange = CharRange.isIn('m', 'p');
       assertTrue(thisRange.contains(otherRange));
   }

   @Test
   void testContains_BothNot_False() {
       CharRange thisRange = CharRange.isIn('a', 'z');
       CharRange otherRange = CharRange.isIn('A', 'Z');
       assertFalse(thisRange.contains(otherRange));
   }
}

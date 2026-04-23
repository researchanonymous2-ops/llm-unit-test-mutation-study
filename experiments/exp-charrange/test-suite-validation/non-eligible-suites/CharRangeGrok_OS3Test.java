package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_OS3Test {

   @Test
   void testContains_NullRange() {
       CharRange outer = CharRange.isIn('a', 'z');
       assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
   }

   @Test
   void testContains_BothNonNegated_Contains() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_BothNonNegated_NotContains() {
       CharRange outer = CharRange.isIn('a', 'f');
       CharRange inner = CharRange.isIn('c', 'z');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_BothNonNegated_Equal() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_BothNonNegated_SingleChar() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.is('c');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_BothNegated_Contains() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_BothNegated_NotContains() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_BothNegated_Equal() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_OuterNegated_InnerNonNegated_Contains() {
       CharRange outer = CharRange.isNotIn('c', 'f');
       CharRange inner = CharRange.isIn('a', 'b');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_OuterNegated_InnerNonNegated_NotContains() {
       CharRange outer = CharRange.isNotIn('a', 'z');
       CharRange inner = CharRange.isIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_OuterNonNegated_InnerNegated_Contains() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNotIn('a', 'z');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_OuterNonNegated_InnerNegated_NotContains() {
       CharRange outer = CharRange.isIn('a', 'z');
       CharRange inner = CharRange.isNotIn('c', 'f');
       assertFalse(outer.contains(inner));
   }

   @Test
   void testContains_OuterNonNegated_InnerNegated_SingleChar() {
       CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
       CharRange inner = CharRange.isNot('a');
       assertTrue(outer.contains(inner));
   }

   @Test
   void testContains_OuterNegated_InnerNegated_SingleChar() {
       CharRange outer = CharRange.isNotIn('b', 'z');
       CharRange inner = CharRange.isNot('a');
       assertTrue(outer.contains(inner));
   }
}

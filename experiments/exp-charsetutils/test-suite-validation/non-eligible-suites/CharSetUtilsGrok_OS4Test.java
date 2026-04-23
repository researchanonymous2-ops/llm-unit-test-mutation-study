package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_OS4Test {

   @Test
   void testSqueeze_NullStr() {
       assertEquals(null, CharSetUtils.squeeze(null, "a"));
   }

   @Test
   void testSqueeze_EmptyStr() {
       assertEquals("", CharSetUtils.squeeze("", "a"));
   }

   @Test
   void testSqueeze_NullSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
   }

   @Test
   void testSqueeze_EmptySet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", ""));
   }

   @Test
   void testSqueeze_NoRepetitions() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   void testSqueeze_RepetitionsNotInSet() {
       assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", "d-f"));
   }

   @Test
   void testSqueeze_RepetitionsInSet() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_NoSqueeze() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_SingleChar() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   void testSqueeze_AllSameInSet() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_AllSameNotInSet() {
       assertEquals("aaa", CharSetUtils.squeeze("aaa", "b"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
   }

   @Test
   void testSqueeze_CaseSensitive() {
       assertEquals("Hello", CharSetUtils.squeeze("Hello", "l"));
   }

   @Test
   void testSqueeze_WithSpaces() {
       assertEquals("a  b", CharSetUtils.squeeze("a  b", " "));
   }

   @Test
   void testSqueeze_StartWithRepetition() {
       assertEquals("ab", CharSetUtils.squeeze("aab", "a"));
   }

   @Test
   void testSqueeze_EndWithRepetition() {
       assertEquals("ab", CharSetUtils.squeeze("abb", "b"));
   }
}

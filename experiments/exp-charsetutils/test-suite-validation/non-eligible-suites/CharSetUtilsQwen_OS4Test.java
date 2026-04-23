package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_OS4Test {

   @Test
   void testSqueeze_nullString() {
       assertEquals(null, CharSetUtils.squeeze(null, "a-z"));
   }

   @Test
   void testSqueeze_emptyString() {
       assertEquals("", CharSetUtils.squeeze("", "a-z"));
   }

   @Test
   void testSqueeze_nullSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
   }

   @Test
   void testSqueeze_emptySetArray() {
       assertEquals("hello", CharSetUtils.squeeze("hello"));
   }

   @Test
   void testSqueeze_emptyStringInSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", ""));
   }

   @Test
   void testSqueeze_noRepetitionNoMatch() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "d-f"));
   }

   @Test
   void testSqueeze_repetitionMatch() {
       assertEquals("abcb", CharSetUtils.squeeze("aabbcb", "a"));
   }

   @Test
   void testSqueeze_multipleRanges() {
       assertEquals("helo world", CharSetUtils.squeeze("hello  world", "l", "o"));
   }

   @Test
   void testSqueeze_unicodeCharacters() {
       assertEquals("año", CharSetUtils.squeeze("año", "n"));
   }

   @Test
   void testSqueeze_allRepeatingMatch() {
       assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
   }

   @Test
   void testSqueeze_startingRepetition() {
       assertEquals("ab", CharSetUtils.squeeze("aaab", "a"));
   }

   @Test
   void testSqueeze_endingRepetition() {
       assertEquals("ba", CharSetUtils.squeeze("baaa", "a"));
   }

   @Test
   void testSqueeze_mixedCaseSensitivity() {
       assertEquals("AaBbCc", CharSetUtils.squeeze("AaaBbbCcc", "a", "b", "c"));
   }

   @Test
   void testSqueeze_specialCharacters() {
       assertEquals("hel*o", CharSetUtils.squeeze("hel****o", "*"));
   }

   @Test
   void testSqueeze_disjointSets() {
       assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", "d-e"));
   }
}

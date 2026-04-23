package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_OS5Test {

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
   void testSqueeze_emptySet() {
       assertEquals("hello", CharSetUtils.squeeze("hello"));
   }

   @Test
   void testSqueeze_singleCharacterRepeated() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
   }

   @Test
   void testSqueeze_multipleCharactersRepeated() {
       assertEquals("helo world", CharSetUtils.squeeze("helllo worrld", "l", "r"));
   }

   @Test
   void testSqueeze_noRepetition() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "x"));
   }

   @Test
   void testSqueeze_rangeSet() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "a-z"));
   }

   @Test
   void testSqueeze_mixedRepetitions() {
       assertEquals("abcabc", CharSetUtils.squeeze("aabbccabc", "b", "a", "c"));
   }

   @Test
   void testSqueeze_unicodeCharacters() {
       assertEquals("café", CharSetUtils.squeeze("caaafé", "a"));
   }

   @Test
   void testSqueeze_adjacentDifferentChars() {
       assertEquals("abab", CharSetUtils.squeeze("aabbab", "a", "b"));
   }

   @Test
   void testSqueeze_emptyStringWithSet() {
       assertEquals("", CharSetUtils.squeeze("", "a"));
   }
}

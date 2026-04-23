package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_FS5Test {

   @Test
   void testSqueeze_nullString() {
       assertNull(CharSetUtils.squeeze(null, "a-z"));
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
       assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
   }

   @Test
   void testSqueeze_mixedRepeatsInSet() {
       assertEquals("ababa", CharSetUtils.squeeze("aaabbbabbbba", "b"));
   }

   @Test
   void testSqueeze_noMatchInSet() {
       assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", "d-f"));
   }

   @Test
   void testSqueeze_complexSetSyntax() {
       assertEquals("helo wrd", CharSetUtils.squeeze("hello world", "l", "o"));
   }

   @Test
   void testSqueeze_multipleRanges() {
       assertEquals("abc123", CharSetUtils.squeeze("aabbcc112233", "b", "c", "2", "3"));
   }

   @Test
   void testSqueeze_unicodeCharacters() {
       assertEquals("héllo", CharSetUtils.squeeze("hélloo", "o"));
   }

   @Test
   void testSqueeze_adjacentDifferentChars() {
       assertEquals("abcabc", CharSetUtils.squeeze("aabbcc", "x"));
   }

   @Test
   void testSqueeze_firstCharRepeated() {
       assertEquals("ab", CharSetUtils.squeeze("aaab", "a"));
   }
}

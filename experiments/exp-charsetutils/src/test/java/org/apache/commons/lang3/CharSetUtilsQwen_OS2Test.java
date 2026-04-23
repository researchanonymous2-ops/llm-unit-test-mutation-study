package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_OS2Test {

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
   void testSqueeze_noRepetition() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-z"));
   }

   @Test
   void testSqueeze_withRepetition() {
       assertEquals("abcb", CharSetUtils.squeeze("aabbcb", "a-z"));
   }

   @Test
   void testSqueeze_partialMatch() {
       assertEquals("helo world", CharSetUtils.squeeze("hello world", "l"));
   }

   @Test
   void testSqueeze_multipleRanges() {
       assertEquals("abc123", CharSetUtils.squeeze("aabbcc112233", "a-c", "0-3"));
   }

   @Test
   void testSqueeze_nonMatchingSet() {
       assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", "x-z"));
   }

   @Test
   void testSqueeze_specialCharacters() {
       assertEquals("a*b*c", CharSetUtils.squeeze("a**b**c", "*"));
   }

   @Test
   void testSqueeze_unicodeCharacters() {
       assertEquals("ñoño", CharSetUtils.squeeze("ñooñoo", "o"));
   }

   @Test
   void testSqueeze_firstCharacterRepetition() {
       assertEquals("abccba", CharSetUtils.squeeze("aaabccba", "a"));
   }

   @Test
   void testSqueeze_mixedCase() {
       assertEquals("AaBbCc", CharSetUtils.squeeze("AaaBbbCcc", "A-Za-z"));
   }

   @Test
   void testSqueeze_emptyStringWithSet() {
       assertEquals("", CharSetUtils.squeeze("", "a"));
   }

   @Test
   void testSqueeze_singleCharacterString() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   void testSqueeze_allSameCharacters() {
       assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
   }

   @Test
   void testSqueeze_consecutiveSets() {
       assertEquals("abcd", CharSetUtils.squeeze("aabbccdd", "a-d"));
   }

   @Test
   void testSqueeze_overlappingRanges() {
       assertEquals("abc", CharSetUtils.squeeze("aabbcc", "a-c", "b-d"));
   }

   @Test
   void testSqueeze_negationSet() {
       assertEquals("a^b^c", CharSetUtils.squeeze("a^^b^^c", "^"));
   }

   @Test
   void testSqueeze_dashInSet() {
       assertEquals("a-b-c", CharSetUtils.squeeze("a--b--c", "-"));
   }
}

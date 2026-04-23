package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_FS3Test {

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
   void testSqueeze_emptySetArray() {
       assertEquals("hello", CharSetUtils.squeeze("hello"));
   }

   @Test
   void testSqueeze_emptyStringInSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", ""));
   }

   @Test
   void testSqueeze_noMatch() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "d-f"));
   }

   @Test
   void testSqueeze_singleCharacterRepeated() {
       assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
   }

   @Test
   void testSqueeze_mixedRepeats() {
       assertEquals("ababa", CharSetUtils.squeeze("aabbbaaabbbbaa", "b"));
   }

   @Test
   void testSqueeze_multipleSets() {
       assertEquals("helo wrld", CharSetUtils.squeeze("hello world", "o", "l"));
   }

   @Test
   void testSqueeze_rangeSet() {
       assertEquals("abcd", CharSetUtils.squeeze("aabbccdd", "b-d"));
   }

   @Test
   void testSqueeze_specialCharacters() {
       assertEquals("a*b*c", CharSetUtils.squeeze("a**b**c", "*"));
   }

   @Test
   void testSqueeze_unicodeCharacters() {
       assertEquals("café", CharSetUtils.squeeze("caaafééé", "aé"));
   }

   @Test
   void testSqueeze_adjacentDifferentChars() {
       assertEquals("abcabc", CharSetUtils.squeeze("abcabc", "a-c"));
   }

   @Test
   void testSqueeze_allSameChar() {
       assertEquals("x", CharSetUtils.squeeze("xxxxxxxxxx", "x"));
   }

   @Test
   void testSqueeze_caseSensitive() {
       assertEquals("AaAa", CharSetUtils.squeeze("AaaAAa", "a"));
   }
}

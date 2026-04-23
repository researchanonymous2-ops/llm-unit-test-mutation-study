package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_OS3Test {

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
       assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", (String[]) null));
   }

   @Test
   void testSqueeze_emptySet() {
       assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", ""));
   }

   @Test
   void testSqueeze_noRepetition() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-z"));
   }

   @Test
   void testSqueeze_withRepetitionInSet() {
       assertEquals("abcb", CharSetUtils.squeeze("aabbcb", "b"));
   }

   @Test
   void testSqueeze_multipleSets() {
       assertEquals("helo wrd", CharSetUtils.squeeze("hello world", "e", "l", "o"));
   }

   @Test
   void testSqueeze_repetitionNotInSet() {
       assertEquals("xxyyzz", CharSetUtils.squeeze("xxyyzz", "a-c"));
   }

   @Test
   void testSqueeze_mixedRepetition() {
       assertEquals("abacadaeaf", CharSetUtils.squeeze("abacadaeaf", "b"));
   }

   @Test
   void testSqueeze_allSameCharacter() {
       assertEquals("a", CharSetUtils.squeeze("aaaaa", "a"));
   }

   @Test
   void testSqueeze_specialCharacters() {
       assertEquals("a*b*c", CharSetUtils.squeeze("a**b***c", "*"));
   }

   @Test
   void testSqueeze_unicodeCharacters() {
       assertEquals("ñoño", CharSetUtils.squeeze("ñooñoo", "o"));
   }
}

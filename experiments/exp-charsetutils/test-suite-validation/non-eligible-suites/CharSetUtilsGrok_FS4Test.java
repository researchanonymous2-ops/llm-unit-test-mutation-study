package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_FS4Test {

   @Test
   void testSqueeze_NullString() {
       assertNull(CharSetUtils.squeeze(null, "a-z"));
   }

   @Test
   void testSqueeze_EmptyString() {
       assertEquals("", CharSetUtils.squeeze("", "a-z"));
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
   void testSqueeze_NoMatchingCharacters() {
       assertEquals("world", CharSetUtils.squeeze("world", "a-c"));
   }

   @Test
   void testSqueeze_SingleCharacterString() {
       assertEquals("a", CharSetUtils.squeeze("a", "a-z"));
   }

   @Test
   void testSqueeze_RemoveConsecutiveDuplicates() {
       assertEquals("helo", CharSetUtils.squeeze("helloo", "l-o"));
   }

   @Test
   void testSqueeze_NoConsecutiveDuplicates() {
       assertEquals("abcabc", CharSetUtils.squeeze("abcabc", "a-c"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
   }

   @Test
   void testSqueeze_WithRange() {
       assertEquals("a1b2c", CharSetUtils.squeeze("aa11bb22cc", "a-z"));
   }

   @Test
   void testSqueeze_AllCharactersInSet() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_MixedCase() {
       assertEquals("Helo", CharSetUtils.squeeze("Heello", "e-l"));
   }
}

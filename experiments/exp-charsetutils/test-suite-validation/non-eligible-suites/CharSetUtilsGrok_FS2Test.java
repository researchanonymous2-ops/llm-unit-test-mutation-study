package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_FS2Test {

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
   void testSqueeze_NoRepetitions() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   void testSqueeze_WithRepetitionsInSet() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_WithRepetitionsNotInSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_MultipleRepetitions() {
       assertEquals("ab", CharSetUtils.squeeze("aabb", "a-b"));
   }

   @Test
   void testSqueeze_MixedCharacters() {
       assertEquals("a1b2c", CharSetUtils.squeeze("a11b22c", "1-2"));
   }

   @Test
   void testSqueeze_SingleCharacterSet() {
       assertEquals("ab", CharSetUtils.squeeze("aab", "a"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
   }

   @Test
   void testSqueeze_AllRepetitions() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_NoMatchInSet() {
       assertEquals("xyz", CharSetUtils.squeeze("xyz", "a-c"));
   }
}

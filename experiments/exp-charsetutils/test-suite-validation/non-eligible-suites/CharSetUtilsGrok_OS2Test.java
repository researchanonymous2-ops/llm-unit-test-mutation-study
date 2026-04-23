package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_OS2Test {

   @Test
   void testSqueeze_NullString() {
       assertEquals(null, CharSetUtils.squeeze(null, "a"));
   }

   @Test
   void testSqueeze_EmptyString() {
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
   void testSqueeze_EmptyArraySet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", new String[0]));
   }

   @Test
   void testSqueeze_NoRepetitions() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   void testSqueeze_RepetitionsNotInSet() {
       assertEquals("aabb", CharSetUtils.squeeze("aabb", "c-d"));
   }

   @Test
   void testSqueeze_RepetitionsInSet() {
       assertEquals("ab", CharSetUtils.squeeze("aabb", "a-b"));
   }

   @Test
   void testSqueeze_Example1() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_Example2() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_SingleChar() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   void testSqueeze_AllSame() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_NonConsecutive() {
       assertEquals("aba", CharSetUtils.squeeze("aba", "a"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("ab", CharSetUtils.squeeze("aaabbb", "a", "b"));
   }

   @Test
   void testSqueeze_SpecialChars() {
       assertEquals("a!b", CharSetUtils.squeeze("aa!!bb", "!"));
   }

   @Test
   void testSqueeze_WithNullInSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a", null, "b"));
   }
}

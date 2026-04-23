package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_OS1Test {

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
   void testSqueeze_SingleCharRepeat() {
       assertEquals("ab", CharSetUtils.squeeze("aaab", "a"));
   }

   @Test
   void testSqueeze_MultipleCharsRepeat() {
       assertEquals("ab", CharSetUtils.squeeze("aaabbb", "a-b"));
   }

   @Test
   void testSqueeze_NoRepeat() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a"));
   }

   @Test
   void testSqueeze_NonConsecutiveRepeat() {
       assertEquals("aba", CharSetUtils.squeeze("aba", "a"));
   }

   @Test
   void testSqueeze_MixedRepeats() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_NoMatch() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("heelloo", "l", "o"));
   }

   @Test
   void testSqueeze_AllRepeats() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_EmptySetArray() {
       assertEquals("test", CharSetUtils.squeeze("test", new String[]{}));
   }
}

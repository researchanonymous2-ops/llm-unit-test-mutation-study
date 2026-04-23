package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_FS1Test {

   @Test
   void testSqueeze_NullInput() {
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
   void testSqueeze_SingleCharacterSqueeze() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
   }

   @Test
   void testSqueeze_NoSqueeze() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_RangeSqueeze() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_MultipleConsecutive() {
       assertEquals("abca", CharSetUtils.squeeze("abcca", "c"));
   }

   @Test
   void testSqueeze_AllRepeated() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_EmptySetArray() {
       assertEquals("hello", CharSetUtils.squeeze("hello"));
   }

   @Test
   void testSqueeze_MixedSet() {
       assertEquals("heo", CharSetUtils.squeeze("heello", "l", "e"));
   }
}

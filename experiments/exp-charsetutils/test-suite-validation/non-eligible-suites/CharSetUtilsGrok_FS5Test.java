package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_FS5Test {

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
   void testSqueeze_NoRepeats() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   void testSqueeze_RepeatsInSet() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_RepeatsNotInSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_MultipleRepeats() {
       assertEquals("ab", CharSetUtils.squeeze("aabb", "a-b"));
   }

   @Test
   void testSqueeze_MixedRepeats() {
       assertEquals("abcc", CharSetUtils.squeeze("abccc", "c"));
   }

   @Test
   void testSqueeze_SingleCharRepeat() {
       assertEquals("a", CharSetUtils.squeeze("aa", "a"));
   }

   @Test
   void testSqueeze_AllRepeats() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_WithSpaces() {
       assertEquals("a b", CharSetUtils.squeeze("a  b", " "));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
   }

   @Test
   void testSqueeze_NonConsecutiveRepeats() {
       assertEquals("aba", CharSetUtils.squeeze("aba", "a"));
   }

   @Test
   void testSqueeze_UpperLowerCase() {
       assertEquals("Aa", CharSetUtils.squeeze("AA", "A"));
   }
}

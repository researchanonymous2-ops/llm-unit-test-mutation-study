package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_OS5Test {

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
   void testSqueeze_RemoveConsecutive() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_NoRemoval() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_SingleCharacter() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   void testSqueeze_AllSameCharactersInSet() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_AllSameCharactersNotInSet() {
       assertEquals("aaa", CharSetUtils.squeeze("aaa", "b"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
   }

   @Test
   void testSqueeze_MixedCase() {
       assertEquals("HeLo", CharSetUtils.squeeze("HeLLo", "L"));
   }

   @Test
   void testSqueeze_NonConsecutive() {
       assertEquals("aba", CharSetUtils.squeeze("aba", "a"));
   }

   @Test
   void testSqueeze_EmptySetArray() {
       assertEquals("hello", CharSetUtils.squeeze("hello"));
   }
}

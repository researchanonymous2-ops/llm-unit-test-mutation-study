package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_FS3Test {

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
   void testSqueeze_SingleCharacter() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   void testSqueeze_NoRepeats() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   void testSqueeze_WithRepeatsInSet() {
       assertEquals("ab", CharSetUtils.squeeze("aabb", "a-b"));
   }

   @Test
   void testSqueeze_WithRepeatsNotInSet() {
       assertEquals("aabb", CharSetUtils.squeeze("aabb", "c-d"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("ab", CharSetUtils.squeeze("aabbcc", "a-b", "c"));
   }

   @Test
   void testSqueeze_AllRepeats() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_MixedCase() {
       assertEquals("Abc", CharSetUtils.squeeze("Abbc", "b"));
   }
}

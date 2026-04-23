package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_COC1Test {

   @Test
   public void testSqueeze_NullStr() {
       assertEquals(null, CharSetUtils.squeeze(null, "a"));
   }

   @Test
   public void testSqueeze_EmptyStr() {
       assertEquals("", CharSetUtils.squeeze("", "a"));
   }

   @Test
   public void testSqueeze_NullSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
   }

   @Test
   public void testSqueeze_EmptySet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", ""));
   }

   @Test
   public void testSqueeze_NoSqueeze() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   public void testSqueeze_Squeeze() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   public void testSqueeze_SingleCharRepeat() {
       assertEquals("a", CharSetUtils.squeeze("aa", "a"));
   }

   @Test
   public void testSqueeze_MultipleRepeats() {
       assertEquals("ab", CharSetUtils.squeeze("aabb", "a", "b"));
   }

   @Test
   public void testSqueeze_NoMatch() {
       assertEquals("xyz", CharSetUtils.squeeze("xyz", "a"));
   }
}

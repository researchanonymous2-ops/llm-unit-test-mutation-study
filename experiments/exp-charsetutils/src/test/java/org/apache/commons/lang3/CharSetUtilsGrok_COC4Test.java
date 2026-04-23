package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_COC4Test {

   @Test
   public void testSqueeze_P0_NullStr() {
       assertEquals(null, CharSetUtils.squeeze(null, "a"));
   }

   @Test
   public void testSqueeze_P0_EmptyStr() {
       assertEquals("", CharSetUtils.squeeze("", "a"));
   }

   @Test
   public void testSqueeze_P1_NullSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
   }

   @Test
   public void testSqueeze_P1_EmptySet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", ""));
   }

   @Test
   public void testSqueeze_P2_NoSqueeze() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "d"));
   }

   @Test
   public void testSqueeze_P3_Squeeze() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
   }

   @Test
   public void testSqueeze_P4_Append() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }
}

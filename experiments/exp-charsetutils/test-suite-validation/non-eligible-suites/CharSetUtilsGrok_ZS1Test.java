package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsGrok_ZS1Test {

   @Test
   public void testSqueeze_NullString() {
       assertNull(CharSetUtils.squeeze(null, "a"));
   }

   @Test
   public void testSqueeze_EmptyString() {
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
   public void testSqueeze_SqueezeSingleChar() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   public void testSqueeze_SqueezeMultipleChars() {
       assertEquals("heo", CharSetUtils.squeeze("heelloo", "e", "o"));
   }

   @Test
   public void testSqueeze_NoRepetitions() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   public void testSqueeze_AllRepetitions() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   public void testSqueeze_MixedRepetitions() {
       assertEquals("abac", CharSetUtils.squeeze("abbaacc", "a", "c"));
   }

   @Test
   public void testSqueeze_SingleCharString() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   public void testSqueeze_SingleCharStringNoMatch() {
       assertEquals("a", CharSetUtils.squeeze("a", "b"));
   }

   @Test
   public void testSqueeze_EmptySetArray() {
       assertEquals("hello", CharSetUtils.squeeze("hello"));
   }

   @Test
   public void testSqueeze_MultipleSets() {
       assertEquals("helo", CharSetUtils.squeeze("heello", "e", "l"));
   }
}

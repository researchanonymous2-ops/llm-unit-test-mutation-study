package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_OS1Test {

   @Test
   void testCompress_EmptyString() {
       assertEquals("", StringCompression.compress(""));
   }

   @Test
   void testCompress_SingleChar() {
       assertEquals("a", StringCompression.compress("a"));
   }

   @Test
   void testCompress_TwoSameChars() {
       assertEquals("a2", StringCompression.compress("aa"));
   }

   @Test
   void testCompress_TwoDifferentChars() {
       assertEquals("ab", StringCompression.compress("ab"));
   }

   @Test
   void testCompress_AllSameChars() {
       assertEquals("a3", StringCompression.compress("aaa"));
   }

   @Test
   void testCompress_NoRepeats() {
       assertEquals("abc", StringCompression.compress("abc"));
   }

   @Test
   void testCompress_MixedRepeats() {
       assertEquals("a2b2c", StringCompression.compress("aabbc"));
   }

   @Test
   void testCompress_EndWithSingle() {
       assertEquals("a2b", StringCompression.compress("aab"));
   }

   @Test
   void testCompress_StartWithSingle() {
       assertEquals("ba3", StringCompression.compress("baaa"));
   }

   @Test
   void testCompress_MultipleGroups() {
       assertEquals("a2bc2", StringCompression.compress("aabbcc"));
   }

   @Test
   void testCompress_LongerRepeats() {
       assertEquals("a4b2", StringCompression.compress("aaaabb"));
   }
}

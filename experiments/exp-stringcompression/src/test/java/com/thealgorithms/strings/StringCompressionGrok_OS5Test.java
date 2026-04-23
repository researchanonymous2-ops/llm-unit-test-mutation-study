package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_OS5Test {

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
       assertEquals("a4", StringCompression.compress("aaaa"));
   }

   @Test
   void testCompress_NoRepeats() {
       assertEquals("abcd", StringCompression.compress("abcd"));
   }

   @Test
   void testCompress_SomeRepeats() {
       assertEquals("a2b2c", StringCompression.compress("aabbc"));
   }

   @Test
   void testCompress_RepeatsAtEnd() {
       assertEquals("a3b", StringCompression.compress("aaab"));
   }

   @Test
   void testCompress_Alternating() {
       assertEquals("abab", StringCompression.compress("abab"));
   }

   @Test
   void testCompress_WithSpaces() {
       assertEquals("a2 b2", StringCompression.compress("aa bb"));
   }

   @Test
   void testCompress_Numbers() {
       assertEquals("1a2b3", StringCompression.compress("1aabbb"));
   }
}

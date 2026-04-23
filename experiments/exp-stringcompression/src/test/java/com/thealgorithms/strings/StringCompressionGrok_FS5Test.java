package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_FS5Test {

   @Test
   void testCompress_SingleCharacter() {
       assertEquals("a", StringCompression.compress("a"));
   }

   @Test
   void testCompress_AllSameCharacters() {
       assertEquals("b4", StringCompression.compress("bbbb"));
   }

   @Test
   void testCompress_NoRepeats() {
       assertEquals("xyz", StringCompression.compress("xyz"));
   }

   @Test
   void testCompress_MixedRepeats() {
       assertEquals("a2b3c", StringCompression.compress("aabbbc"));
   }

   @Test
   void testCompress_EndWithSingle() {
       assertEquals("a3b", StringCompression.compress("aaab"));
   }

   @Test
   void testCompress_StartWithSingle() {
       assertEquals("ab2", StringCompression.compress("abb"));
   }

   @Test
   void testCompress_TwoDifferent() {
       assertEquals("ab", StringCompression.compress("ab"));
   }

   @Test
   void testCompress_LongRepeats() {
       assertEquals("c5", StringCompression.compress("ccccc"));
   }

   @Test
   void testCompress_Alternating() {
       assertEquals("abab", StringCompression.compress("abab"));
   }

   @Test
   void testCompress_SingleThenRepeats() {
       assertEquals("a2b2", StringCompression.compress("aabb"));
   }
}

package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_FS2Test {

   @Test
   void testCompress_SingleCharacter() {
       assertEquals("a", StringCompression.compress("a"));
   }

   @Test
   void testCompress_TwoSameCharacters() {
       assertEquals("a2", StringCompression.compress("aa"));
   }

   @Test
   void testCompress_ThreeSameCharacters() {
       assertEquals("a3", StringCompression.compress("aaa"));
   }

   @Test
   void testCompress_MixedCharacters() {
       assertEquals("a2b", StringCompression.compress("aab"));
   }

   @Test
   void testCompress_AllDifferent() {
       assertEquals("abc", StringCompression.compress("abc"));
   }

   @Test
   void testCompress_RepeatedGroups() {
       assertEquals("a2b2", StringCompression.compress("aabb"));
   }

   @Test
   void testCompress_LongerRepeated() {
       assertEquals("a3b3", StringCompression.compress("aaabbb"));
   }

   @Test
   void testCompress_SingleAtEnd() {
       assertEquals("a2bc", StringCompression.compress("aabc"));
   }

   @Test
   void testCompress_OnlyTwoDifferent() {
       assertEquals("ab", StringCompression.compress("ab"));
   }

   @Test
   void testCompress_FourSame() {
       assertEquals("a4", StringCompression.compress("aaaa"));
   }
}

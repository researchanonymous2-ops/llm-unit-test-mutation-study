package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_FS1Test {

   @Test
   void testCompress_EmptyString() {
       assertEquals("", StringCompression.compress(""));
   }

   @Test
   void testCompress_SingleCharacter() {
       assertEquals("a", StringCompression.compress("a"));
   }

   @Test
   void testCompress_TwoIdenticalCharacters() {
       assertEquals("a2", StringCompression.compress("aa"));
   }

   @Test
   void testCompress_TwoDifferentCharacters() {
       assertEquals("ab", StringCompression.compress("ab"));
   }

   @Test
   void testCompress_ThreeIdenticalCharacters() {
       assertEquals("a3", StringCompression.compress("aaa"));
   }

   @Test
   void testCompress_MixedWithCountOne() {
       assertEquals("a2b", StringCompression.compress("aab"));
   }

   @Test
   void testCompress_MultipleGroups() {
       assertEquals("a2b2", StringCompression.compress("aabb"));
   }

   @Test
   void testCompress_LastGroupSingle() {
       assertEquals("a3b", StringCompression.compress("aaab"));
   }

   @Test
   void testCompress_AllDifferent() {
       assertEquals("abc", StringCompression.compress("abc"));
   }

   @Test
   void testCompress_LastGroupRepeated() {
       assertEquals("ab2", StringCompression.compress("abcc"));
   }

   @Test
   void testCompress_WithNumbers() {
       assertEquals("12a", StringCompression.compress("11a"));
   }

   @Test
   void testCompress_WithSpaces() {
       assertEquals("a2 b", StringCompression.compress("aa b"));
   }
}

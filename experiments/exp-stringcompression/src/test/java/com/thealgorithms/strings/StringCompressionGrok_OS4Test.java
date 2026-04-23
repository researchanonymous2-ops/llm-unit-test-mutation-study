package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_OS4Test {

   @Test
   void testCompress_SingleCharacter() {
       assertEquals("a", StringCompression.compress("a"));
   }

   @Test
   void testCompress_NoRepeats() {
       assertEquals("abc", StringCompression.compress("abc"));
   }

   @Test
   void testCompress_AllSame() {
       assertEquals("a4", StringCompression.compress("aaaa"));
   }

   @Test
   void testCompress_MixedRepeats() {
       assertEquals("a2b2", StringCompression.compress("aabb"));
   }

   @Test
   void testCompress_EndWithSingle() {
       assertEquals("a3b", StringCompression.compress("aaab"));
   }

   @Test
   void testCompress_StartWithSingle() {
       assertEquals("ab3", StringCompression.compress("abbb"));
   }

   @Test
   void testCompress_Alternating() {
       assertEquals("abab", StringCompression.compress("abab"));
   }

   @Test
   void testCompress_LongRepeats() {
       assertEquals("b5c2", StringCompression.compress("bbbbbcc"));
   }
}

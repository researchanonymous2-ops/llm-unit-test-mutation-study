package com.thealgorithms.strings;

package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_ZS1Test {

   @Test
   public void testCompress_EmptyString() {
       assertEquals("", StringCompression.compress(""));
   }

   @Test
   public void testCompress_SingleCharacter() {
       assertEquals("a", StringCompression.compress("a"));
   }

   @Test
   public void testCompress_NoRepeats() {
       assertEquals("abc", StringCompression.compress("abc"));
   }

   @Test
   public void testCompress_RepeatedCharacters() {
       assertEquals("a2", StringCompression.compress("aa"));
   }

   @Test
   public void testCompress_MultipleRepeats() {
       assertEquals("a2b3", StringCompression.compress("aabbb"));
   }

   @Test
   public void testCompress_AllRepeats() {
       assertEquals("a2b2c2", StringCompression.compress("aabbcc"));
   }

   @Test
   public void testCompress_AllSame() {
       assertEquals("a3", StringCompression.compress("aaa"));
   }

   @Test
   public void testCompress_NonConsecutive() {
       assertEquals("aba", StringCompression.compress("aba"));
   }

   @Test
   public void testCompress_Numbers() {
       assertEquals("13", StringCompression.compress("111"));
   }

   @Test
   public void testCompress_WithSpaces() {
       assertEquals("a2 b2", StringCompression.compress("aa bb"));
   }

   @Test
   public void testCompress_TwoDifferent() {
       assertEquals("ab", StringCompression.compress("ab"));
   }

   @Test
   public void testCompress_SingleRepeatAtEnd() {
       assertEquals("ab2", StringCompression.compress("abb"));
   }
}

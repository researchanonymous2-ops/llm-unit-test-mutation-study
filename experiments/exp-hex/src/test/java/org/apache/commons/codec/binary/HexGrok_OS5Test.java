package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_OS5Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] input = {};
       char[] expected = {};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteZero() {
       byte[] input = {0};
       char[] expected = {'0', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteFifteen() {
       byte[] input = {15};
       char[] expected = {'0', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteNegativeOne() {
       byte[] input = {-1};
       char[] expected = {'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMaxPositive() {
       byte[] input = {127};
       char[] expected = {'7', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMinNegative() {
       byte[] input = {-128};
       char[] expected = {'8', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MultipleBytes() {
       byte[] input = {1, 2, 3};
       char[] expected = {'0', '1', '0', '2', '0', '3'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MixedBytes() {
       byte[] input = {0, 15, -1, 127, -128};
       char[] expected = {'0', '0', '0', 'f', 'f', 'f', '7', 'f', '8', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

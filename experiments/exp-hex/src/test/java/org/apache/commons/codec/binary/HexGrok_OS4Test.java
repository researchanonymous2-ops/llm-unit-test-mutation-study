package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_OS4Test {

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
   void testEncodeHex_SingleByteOne() {
       byte[] input = {1};
       char[] expected = {'0', '1'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteFifteen() {
       byte[] input = {15};
       char[] expected = {'0', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteSixteen() {
       byte[] input = {16};
       char[] expected = {'1', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMax() {
       byte[] input = {(byte) 0xFF};
       char[] expected = {'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMin() {
       byte[] input = {(byte) 0x80};
       char[] expected = {'8', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MultipleBytes() {
       byte[] input = {1, 2, 15, 16};
       char[] expected = {'0', '1', '0', '2', '0', 'f', '1', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_AllZeros() {
       byte[] input = {0, 0, 0};
       char[] expected = {'0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_AllFs() {
       byte[] input = {(byte) 0xFF, (byte) 0xFF};
       char[] expected = {'f', 'f', 'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

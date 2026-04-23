package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_OS1Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] input = {};
       char[] expected = {};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteZero() {
       byte[] input = {0x00};
       char[] expected = {'0', '0'};
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
       byte[] input = {(byte) -128};
       char[] expected = {'8', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteExample() {
       byte[] input = {0x0A};
       char[] expected = {'0', 'a'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MultipleBytes() {
       byte[] input = {0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF};
       char[] expected = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MixedBytes() {
       byte[] input = {(byte) -1, 0x7F, 0x00, 0x10};
       char[] expected = {'f', 'f', '7', 'f', '0', '0', '1', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

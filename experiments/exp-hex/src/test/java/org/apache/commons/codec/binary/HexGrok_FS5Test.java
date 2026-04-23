package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_FS5Test {

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
   void testEncodeHex_SingleByteMid() {
       byte[] input = {0x7F};
       char[] expected = {'7', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_TwoBytes() {
       byte[] input = {0x01, 0x23};
       char[] expected = {'0', '1', '2', '3'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_ThreeBytes() {
       byte[] input = {(byte) 0xAB, (byte) 0xCD, (byte) 0xEF};
       char[] expected = {'a', 'b', 'c', 'd', 'e', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_NegativeByte() {
       byte[] input = {(byte) -1};
       char[] expected = {'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MixedBytes() {
       byte[] input = {0x0F, (byte) 0xF0};
       char[] expected = {'0', 'f', 'f', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_FS3Test {

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
       byte[] input = {0x7F};
       char[] expected = {'7', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMin() {
       byte[] input = {(byte) 0x80};
       char[] expected = {'8', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteFF() {
       byte[] input = {(byte) 0xFF};
       char[] expected = {'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MultipleBytes() {
       byte[] input = {0x12, 0x34, 0x56};
       char[] expected = {'1', '2', '3', '4', '5', '6'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_TwoBytes() {
       byte[] input = {(byte) 0xAB, (byte) 0xCD};
       char[] expected = {'a', 'b', 'c', 'd'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

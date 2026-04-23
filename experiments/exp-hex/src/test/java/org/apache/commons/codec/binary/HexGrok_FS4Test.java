package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_FS4Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] input = {};
       char[] expected = {};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMax() {
       byte[] input = {(byte) 0xFF};
       char[] expected = {'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_TwoBytes() {
       byte[] input = {0x12, 0x34};
       char[] expected = {'1', '2', '3', '4'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_AllZeros() {
       byte[] input = {0x00, 0x00, 0x00};
       char[] expected = {'0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MixedValues() {
       byte[] input = {(byte) 0xAB, (byte) 0xCD};
       char[] expected = {'a', 'b', 'c', 'd'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByte() {
       byte[] input = {0x5A};
       char[] expected = {'5', 'a'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexGrok_OS2Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] input = new byte[0];
       char[] expected = new char[0];
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
   void testEncodeHex_SingleByteMaxPositive() {
       byte[] input = {127};
       char[] expected = {'7', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteNegativeOne() {
       byte[] input = {-1};
       char[] expected = {'f', 'f'};
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
       byte[] input = {0, 1, 15, 16, 127, -1, -128};
       char[] expected = {'0', '0', '0', '1', '0', 'f', '1', '0', '7', 'f', 'f', 'f', '8', '0'};
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
       byte[] input = {-1, -1};
       char[] expected = {'f', 'f', 'f', 'f'};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

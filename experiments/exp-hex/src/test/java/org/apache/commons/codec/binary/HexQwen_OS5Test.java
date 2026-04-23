package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_OS5Test {

   @Test
   void testEncodeHex_emptyArray() {
       byte[] input = {};
       char[] expected = {};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_singleZeroByte() {
       byte[] input = { 0x00 };
       char[] expected = { '0', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_singleNonZeroByte() {
       byte[] input = { (byte) 0xFF };
       char[] expected = { 'f', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_mixedBytes() {
       byte[] input = { 0x12, (byte) 0xAB, 0x3C };
       char[] expected = { '1', '2', 'a', 'b', '3', 'c' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_allZeroBytes() {
       byte[] input = { 0x00, 0x00, 0x00 };
       char[] expected = { '0', '0', '0', '0', '0', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_negativeBytes() {
       byte[] input = { (byte) 0x80, (byte) 0x9A, (byte) 0xFF };
       char[] expected = { '8', '0', '9', 'a', 'f', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_maxValues() {
       byte[] input = { (byte) 0x7F, (byte) 0x80 };
       char[] expected = { '7', 'f', '8', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

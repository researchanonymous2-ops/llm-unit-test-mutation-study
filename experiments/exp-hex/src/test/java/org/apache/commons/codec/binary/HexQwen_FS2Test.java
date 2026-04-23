package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_FS2Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] input = {};
       char[] expected = {};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMaxValue() {
       byte[] input = { (byte) 0xFF };
       char[] expected = { 'f', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MultipleBytesMixedValues() {
       byte[] input = { (byte) 0xAB, (byte) 0x12, (byte) 0x80 };
       char[] expected = { 'a', 'b', '1', '2', '8', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_NegativeByteValue() {
       byte[] input = { (byte) -1 }; // 0xFF
       char[] expected = { 'f', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_LeadingZeroByte() {
       byte[] input = { 0x00, (byte) 0xD3 };
       char[] expected = { '0', '0', 'd', '3' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_TrailingZeroByte() {
       byte[] input = { (byte) 0xCA, 0x00 };
       char[] expected = { 'c', 'a', '0', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_AllBytesFromZeroToFifteen() {
       byte[] input = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F };
       char[] expected = { '0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7',
                           '0', '8', '0', '9', '0', 'a', '0', 'b', '0', 'c', '0', 'd', '0', 'e', '0', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

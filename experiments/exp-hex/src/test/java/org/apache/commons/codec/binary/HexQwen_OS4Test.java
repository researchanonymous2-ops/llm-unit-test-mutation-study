package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_OS4Test {

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
   void testEncodeHex_uppercaseBytes() {
       byte[] input = { (byte) 0xDE, (byte) 0xAD, (byte) 0xBE, (byte) 0xEF };
       char[] expected = { 'd', 'e', 'a', 'd', 'b', 'e', 'e', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_sequentialBytes() {
       byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05 };
       char[] expected = { '0', '1', '0', '2', '0', '3', '0', '4', '0', '5' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_negativeBytes() {
       byte[] input = { (byte) 0x80, (byte) 0x81, (byte) 0xFE, (byte) 0xFF };
       char[] expected = { '8', '0', '8', '1', 'f', 'e', 'f', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

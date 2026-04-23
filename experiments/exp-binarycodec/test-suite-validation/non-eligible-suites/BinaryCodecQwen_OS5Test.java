package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_OS5Test {

   @Test
   void testToAsciiBytes_nullInput() {
       byte[] input = null;
       byte[] expected = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_emptyArray() {
       byte[] input = {};
       byte[] expected = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_singleZeroByte() {
       byte[] input = { 0x00 };
       byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_singleOneByte() {
       byte[] input = { (byte) 0xFF };
       byte[] expected = { '1', '1', '1', '1', '1', '1', '1', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_mixedBits() {
       byte[] input = { (byte) 0xA5 }; // 10100101
       byte[] expected = { '1', '0', '1', '0', '0', '1', '0', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_multipleBytes() {
       byte[] input = { (byte) 0xC3, 0x3C }; // 11000011, 00111100
       byte[] expected = { '1', '1', '0', '0', '0', '0', '1', '1', '0', '0', '1', '1', '1', '1', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_allBitPatterns() {
       byte[] input = { 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, (byte) 0x80 };
       byte[] expected = {
           '0', '0', '0', '0', '0', '0', '0', '1',
           '0', '0', '0', '0', '0', '0', '1', '0',
           '0', '0', '0', '0', '0', '1', '0', '0',
           '0', '0', '0', '0', '1', '0', '0', '0',
           '0', '0', '0', '1', '0', '0', '0', '0',
           '0', '0', '1', '0', '0', '0', '0', '0',
           '0', '1', '0', '0', '0', '0', '0', '0',
           '1', '0', '0', '0', '0', '0', '0', '0'
       };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

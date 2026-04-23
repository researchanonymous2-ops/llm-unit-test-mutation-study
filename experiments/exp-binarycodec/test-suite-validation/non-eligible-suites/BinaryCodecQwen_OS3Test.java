package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_OS3Test {

   @Test
   void testToAsciiBytes_nullInput() {
       byte[] input = null;
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertArrayEquals(new byte[0], result);
   }

   @Test
   void testToAsciiBytes_emptyArray() {
       byte[] input = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertArrayEquals(new byte[0], result);
   }

   @Test
   void testToAsciiBytes_singleZeroByte() {
       byte[] input = { 0x00 };
       byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_singleMaxByte() {
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
       byte[] input = { (byte) 0x0F, (byte) 0xF0 }; // 00001111 11110000
       byte[] expected = { '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_negativeByteValues() {
       byte[] input = { (byte) 0x80, (byte) 0x7F }; // 10000000 01111111
       byte[] expected = { '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

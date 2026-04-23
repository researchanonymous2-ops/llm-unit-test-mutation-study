package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_FS1Test {

   @Test
   void testToAsciiBytes_withNullInput() {
       byte[] result = BinaryCodec.toAsciiBytes(null);
       assertNotNull(result);
       assertEquals(0, result.length);
   }

   @Test
   void testToAsciiBytes_withEmptyArray() {
       byte[] input = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(0, result.length);
   }

   @Test
   void testToAsciiBytes_withSingleZeroByte() {
       byte[] input = { 0x00 };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("00000000", new String(result));
   }

   @Test
   void testToAsciiBytes_withSingleMaxByte() {
       byte[] input = { (byte) 0xFF };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("11111111", new String(result));
   }

   @Test
   void testToAsciiBytes_withAlternatingBits() {
       byte[] input = { (byte) 0xA5 }; // 10100101
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("10100101", new String(result));
   }

   @Test
   void testToAsciiBytes_withMultipleBytes() {
       byte[] input = { (byte) 0x0F, (byte) 0xF0 }; // 00001111 11110000
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(16, result.length);
       assertEquals("0000111111110000", new String(result));
   }

   @Test
   void testToAsciiBytes_withSingleBitSetAtEnd() {
       byte[] input = { 0x01 };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("00000001", new String(result));
   }

   @Test
   void testToAsciiBytes_withSingleBitSetAtStart() {
       byte[] input = { (byte) 0x80 };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("10000000", new String(result));
   }
}

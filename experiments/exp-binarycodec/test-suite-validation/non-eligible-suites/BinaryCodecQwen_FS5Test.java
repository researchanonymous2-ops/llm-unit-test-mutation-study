package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_FS5Test {

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
   void testToAsciiBytes_withAlternatingBitsByte() {
       byte[] input = { 0x55 }; // 01010101
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("01010101", new String(result));
   }

   @Test
   void testToAsciiBytes_withTwoBytes() {
       byte[] input = { 0x0F, (byte) 0xF0 }; // 00001111 11110000
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(16, result.length);
       assertEquals("0000111111110000", new String(result));
   }

   @Test
   void testToAsciiBytes_withNegativeByte() {
       byte[] input = { (byte) 0x80 }; // 10000000
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(8, result.length);
       assertEquals("10000000", new String(result));
   }

   @Test
   void testToAsciiBytes_withMixedBytes() {
       byte[] input = { 0x01, 0x02, 0x04, 0x08 }; // 00000001 00000010 00000100 00001000
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(32, result.length);
       assertEquals("00000001000000100000010000001000", new String(result));
   }
}

package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_FS2Test {

   @Test
   void testToAsciiBytes_withNullInput() {
       byte[] input = null;
       byte[] result = BinaryCodec.toAsciiBytes(input);
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
       byte[] input = { (byte) 0x80, 0x01 }; // 10000000 00000001
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(16, result.length);
       assertEquals("1000000000000001", new String(result));
   }

   @Test
   void testToAsciiBytes_withNegativeAndPositiveBytes() {
       byte[] input = { (byte) 0x81, 0x7E }; // 10000001 01111110
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(16, result.length);
       assertEquals("1000000101111110", new String(result));
   }

   @Test
   void testToAsciiBytes_withAllBitsSetInOrder() {
       byte[] input = { 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, (byte) 0x80 };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertEquals(64, result.length);
       assertEquals("0000000100000010000001000000100000010000001000000100000010000000", new String(result));
   }
}

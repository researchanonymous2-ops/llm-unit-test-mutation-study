package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_OS1Test {

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
   void testToAsciiBytes_singleOneByte() {
       byte[] input = { (byte) 0xFF };
       byte[] expected = { '1', '1', '1', '1', '1', '1', '1', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_mixedBits() {
       byte[] input = { (byte) 0xA5 };
       byte[] expected = { '1', '0', '1', '0', '0', '1', '0', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_multipleBytes() {
       byte[] input = { (byte) 0xC3, 0x3C };
       byte[] expected = { '1', '1', '0', '0', '0', '0', '1', '1', '0', '0', '1', '1', '1', '1', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_allBytesWithAlternatingBits() {
       byte[] input = { 0x55, (byte) 0xAA };
       byte[] expected = { '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_singleByteWithSingleHighBit() {
       byte[] input = { 0x40 };
       byte[] expected = { '0', '1', '0', '0', '0', '0', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_boundaryByteValues() {
       byte[] input = { 0x01, (byte) 0x80 };
       byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_sequentialBytes() {
       byte[] input = { 0x03, 0x07, 0x0F };
       byte[] expected = { '0', '0', '0', '0', '0', '0', '1', '1', 
                           '0', '0', '0', '0', '0', '1', '1', '1', 
                           '0', '0', '0', '0', '1', '1', '1', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

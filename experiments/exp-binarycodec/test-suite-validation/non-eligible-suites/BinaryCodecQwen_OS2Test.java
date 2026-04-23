package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_OS2Test {

   @Test
   void testToAsciiBytes_emptyArray() {
       byte[] input = {};
       byte[] expected = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_nullInput() {
       byte[] input = null;
       byte[] expected = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertNotNull(result);
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
       byte[] input = { 0x0F };
       byte[] expected = { '0', '0', '0', '0', '1', '1', '1', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_multipleBytes() {
       byte[] input = { 0x00, (byte) 0xFF };
       byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_alternatingPattern() {
       byte[] input = { 0x55 };
       byte[] expected = { '0', '1', '0', '1', '0', '1', '0', '1' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_inverseAlternatingPattern() {
       byte[] input = { (byte) 0xAA };
       byte[] expected = { '1', '0', '1', '0', '1', '0', '1', '0' };
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

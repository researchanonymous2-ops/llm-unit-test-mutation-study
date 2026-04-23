package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_FS2Test {

   @Test
   void testToAsciiBytes_NullInput() {
       byte[] input = null;
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(0, result.length);
   }

   @Test
   void testToAsciiBytes_EmptyArray() {
       byte[] input = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(0, result.length);
   }

   @Test
   void testToAsciiBytes_SingleByteZero() {
       byte[] input = {0x00};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteAllOnes() {
       byte[] input = {(byte) 0xFF};
       byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteMixed() {
       byte[] input = {0x0A};
       byte[] expected = {'0', '1', '0', '1', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_TwoBytes() {
       byte[] input = {0x01, (byte) 0x80};
       byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_ThreeBytes() {
       byte[] input = {(byte) 0xF0, 0x0F, 0x55};
       byte[] expected = {'0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_OS5Test {

   @Test
   void testToAsciiBytes_NullInput() {
       byte[] result = BinaryCodec.toAsciiBytes(null);
       assertArrayEquals(new byte[0], result);
   }

   @Test
   void testToAsciiBytes_EmptyArray() {
       byte[] input = new byte[0];
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(new byte[0], result);
   }

   @Test
   void testToAsciiBytes_SingleByteZero() {
       byte[] input = {0};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteOne() {
       byte[] input = {1};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteMaxValue() {
       byte[] input = {(byte) 255};
       byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_MultipleBytes() {
       byte[] input = {0, 1, (byte) 255};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteMiddleValue() {
       byte[] input = {85}; // 01010101 in binary
       byte[] expected = {'0', '1', '0', '1', '0', '1', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

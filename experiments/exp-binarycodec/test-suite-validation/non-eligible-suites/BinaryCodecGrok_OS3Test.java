package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_OS3Test {

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
       byte[] input = {0x00};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteOne() {
       byte[] input = {0x01};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_SingleByteHighBit() {
       byte[] input = {(byte) 0x80};
       byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0'};
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
   void testToAsciiBytes_TwoBytes() {
       byte[] input = {0x00, 0x01};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }

   @Test
   void testToAsciiBytes_MultipleBytes() {
       byte[] input = {(byte) 0xAB, (byte) 0xCD};
       byte[] expected = {'1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertArrayEquals(expected, result);
   }
}

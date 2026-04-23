package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_ZS5Test {

   @Test
   public void testToAsciiBytes_NullInput() {
       assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(null));
   }

   @Test
   public void testToAsciiBytes_EmptyArray() {
       assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(new byte[0]));
   }

   @Test
   public void testToAsciiBytes_SingleByteZero() {
       byte[] input = {0};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_SingleByteOne() {
       byte[] input = {1};
       byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_SingleByteAllOnes() {
       byte[] input = {(byte) 255};
       byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_SingleByteAlternatingBits() {
       byte[] input = {(byte) 170}; // 0b10101010
       byte[] expected = {'0', '1', '0', '1', '0', '1', '0', '1'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_MultipleBytes() {
       byte[] input = {0, 1};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_LargerInput() {
       byte[] input = {(byte) 240, (byte) 15}; // 0b11110000, 0b00001111
       byte[] expected = {'0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }
}

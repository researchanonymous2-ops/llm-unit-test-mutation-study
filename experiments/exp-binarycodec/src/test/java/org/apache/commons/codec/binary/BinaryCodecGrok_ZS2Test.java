package org.apache.commons.codec.binary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.BinaryCodec;

public class BinaryCodecGrok_ZS2Test {

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
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_SingleByteAllOnes() {
       byte[] input = {(byte) 255};
       byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_SingleByteMSBSet() {
       byte[] input = {(byte) 128};
       byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_SingleByteMixed() {
       byte[] input = {(byte) 170}; // 10101010
       byte[] expected = {'1', '0', '1', '0', '1', '0', '1', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_TwoBytes() {
       byte[] input = {0, 1};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }

   @Test
   public void testToAsciiBytes_MultipleBytes() {
       byte[] input = {(byte) 255, 0, (byte) 128};
       byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1'};
       assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
   }
}

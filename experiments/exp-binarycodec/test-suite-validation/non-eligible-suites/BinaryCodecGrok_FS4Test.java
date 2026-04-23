package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_FS4Test {

   @Test
   void testToAsciiBytes_EmptyArray() {
       byte[] input = {};
       byte[] expected = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }

   @Test
   void testToAsciiBytes_NullInput() {
       byte[] input = null;
       byte[] expected = {};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }

   @Test
   void testToAsciiBytes_SingleByteZero() {
       byte[] input = {0x00};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }

   @Test
   void testToAsciiBytes_SingleByteMax() {
       byte[] input = {(byte) 0xFF};
       byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }

   @Test
   void testToAsciiBytes_SingleByteMixed() {
       byte[] input = {0x0A};
       byte[] expected = {'0', '0', '0', '0', '1', '0', '1', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }

   @Test
   void testToAsciiBytes_MultipleBytes() {
       byte[] input = {0x01, (byte) 0x80};
       byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }

   @Test
   void testToAsciiBytes_NegativeByte() {
       byte[] input = {(byte) 0xF0};
       byte[] expected = {'1', '1', '1', '1', '0', '0', '0', '0'};
       byte[] result = BinaryCodec.toAsciiBytes(input);
       assertEquals(expected.length, result.length);
       for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], result[i]);
       }
   }
}

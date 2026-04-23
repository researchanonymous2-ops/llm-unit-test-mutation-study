package org.apache.commons.codec.binary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecGrok_ZS1Test {

   @Test
   public void testToAsciiBytes_Null() {
       byte[] raw = null;
       byte[] expected = BinaryCodec.EMPTY_BYTE_ARRAY;
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }

   @Test
   public void testToAsciiBytes_Empty() {
       byte[] raw = new byte[0];
       byte[] expected = BinaryCodec.EMPTY_BYTE_ARRAY;
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }

   @Test
   public void testToAsciiBytes_SingleByteZero() {
       byte[] raw = new byte[]{0};
       byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0'};
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }

   @Test
   public void testToAsciiBytes_SingleByteOne() {
       byte[] raw = new byte[]{1};
       byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '1'};
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }

   @Test
   public void testToAsciiBytes_SingleByteAllOnes() {
       byte[] raw = new byte[]{-1};
       byte[] expected = new byte[]{'1', '1', '1', '1', '1', '1', '1', '1'};
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }

   @Test
   public void testToAsciiBytes_SingleByteMixed() {
       byte[] raw = new byte[]{85}; // 01010101
       byte[] expected = new byte[]{'0', '1', '0', '1', '0', '1', '0', '1'};
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }

   @Test
   public void testToAsciiBytes_MultipleBytes() {
       byte[] raw = new byte[]{0, 1};
       byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
       byte[] actual = BinaryCodec.toAsciiBytes(raw);
       assertArrayEquals(expected, actual);
   }
}

package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_OS2Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] input = {};
       char[] expected = {};
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteZero() {
       byte[] input = { 0x00 };
       char[] expected = { '0', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_SingleByteMax() {
       byte[] input = { (byte) 0xFF };
       char[] expected = { 'f', 'f' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MultipleBytes() {
       byte[] input = { 0x12, (byte) 0xAB, 0x3C };
       char[] expected = { '1', '2', 'a', 'b', '3', 'c' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_NegativeByte() {
       byte[] input = { (byte) 0x80 };
       char[] expected = { '8', '0' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }

   @Test
   void testEncodeHex_MixedPositiveAndNegativeBytes() {
       byte[] input = { 0x01, (byte) 0xFE, 0x02, (byte) 0xFD };
       char[] expected = { '0', '1', 'f', 'e', '0', '2', 'f', 'd' };
       assertArrayEquals(expected, Hex.encodeHex(input));
   }
}

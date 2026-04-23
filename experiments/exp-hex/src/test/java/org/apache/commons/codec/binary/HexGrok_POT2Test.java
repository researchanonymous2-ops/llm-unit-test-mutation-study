package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HexGrok_POT2Test {

   @Test
   void testEncodeHex_EmptyArray() {
       byte[] data = new byte[0];
       char[] result = Hex.encodeHex(data);
       assertEquals(0, result.length);
   }

   @Test
   void testEncodeHex_SingleByte() {
       byte[] data = {0x00};
       char[] result = Hex.encodeHex(data);
       assertEquals(2, result.length);
       assertArrayEquals(new char[]{'0', '0'}, result);
   }

   @Test
   void testEncodeHex_MultipleBytes() {
       byte[] data = {0x00, 0x01};
       char[] result = Hex.encodeHex(data);
       assertEquals(4, result.length);
       assertArrayEquals(new char[]{'0', '0', '0', '1'}, result);
   }
}

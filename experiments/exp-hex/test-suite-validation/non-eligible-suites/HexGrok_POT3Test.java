package org.apache.commons.codec.binary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_POT3Test {

   @Test
   public void testEncodeHex_EmptyArray() {
       byte[] data = new byte[0];
       char[] result = Hex.encodeHex(data);
       assertEquals(0, result.length);
   }

   @Test
   public void testEncodeHex_SingleByte() {
       byte[] data = {0x0F};
       char[] result = Hex.encodeHex(data);
       assertEquals(2, result.length);
   }

   @Test
   public void testEncodeHex_MultipleBytes() {
       byte[] data = {0x0F, 0xFF};
       char[] result = Hex.encodeHex(data);
       assertEquals(2 * data.length, result.length);
   }
}

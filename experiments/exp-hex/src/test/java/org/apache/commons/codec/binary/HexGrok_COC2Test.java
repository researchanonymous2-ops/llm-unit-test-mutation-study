package org.apache.commons.codec.binary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_COC2Test {

   @Test
   public void testEncodeHex_EmptyArray() {
       byte[] input = new byte[0];
       char[] expected = new char[0];
       char[] result = Hex.encodeHex(input);
       assertArrayEquals(expected, result);
   }

   @Test
   public void testEncodeHex_SingleByte() {
       byte[] input = new byte[]{(byte) 0xAB};
       char[] expected = new char[]{'a', 'b'};
       char[] result = Hex.encodeHex(input);
       assertArrayEquals(expected, result);
   }

   @Test
   public void testEncodeHex_MultipleBytes() {
       byte[] input = new byte[]{(byte) 0xAB, (byte) 0xCD};
       char[] expected = new char[]{'a', 'b', 'c', 'd'};
       char[] result = Hex.encodeHex(input);
       assertArrayEquals(expected, result);
   }
}

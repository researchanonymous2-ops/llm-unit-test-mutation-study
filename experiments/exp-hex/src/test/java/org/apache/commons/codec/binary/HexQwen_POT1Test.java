package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexQwen_POT1Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = new byte[0];
        char[] result = Hex.encodeHex(input);
        assertEquals(0, result.length);
    }

    @Test
    public void testEncodeHex_singleByte() {
        byte[] input = new byte[]{(byte) 0xAB};
        char[] result = Hex.encodeHex(input);
        assertEquals(2, result.length);
        assertEquals('a', result[0]);
        assertEquals('b', result[1]);
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0x12};
        char[] result = Hex.encodeHex(input);
        assertEquals(6, result.length);
        assertEquals('a', result[0]);
        assertEquals('b', result[1]);
        assertEquals('c', result[2]);
        assertEquals('d', result[3]);
        assertEquals('1', result[4]);
        assertEquals('2', result[5]);
    }
}
// ```
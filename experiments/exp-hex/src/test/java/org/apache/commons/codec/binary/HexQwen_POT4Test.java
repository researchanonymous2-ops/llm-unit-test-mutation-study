package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexQwen_POT4Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = new byte[0];
        char[] result = Hex.encodeHex(input);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testEncodeHex_singleByte() {
        byte[] input = new byte[]{(byte) 0xAB};
        char[] result = Hex.encodeHex(input);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals('a', result[0]);
        assertEquals('b', result[1]);
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = new byte[]{(byte) 0xAB, (byte) 0x12, (byte) 0xFF};
        char[] result = Hex.encodeHex(input);
        assertNotNull(result);
        assertEquals(6, result.length);
        assertEquals("ab12ff", new String(result));
    }
}
// ```
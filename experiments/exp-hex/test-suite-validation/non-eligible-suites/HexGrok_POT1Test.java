package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexGrok_POT1Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] data = new byte[0];
        char[] result = Hex.encodeHex(data);
        assertEquals(0, result.length);
    }

    @Test
    void testEncodeHex_SingleByte() {
        byte[] data = new byte[]{0x00};
        char[] result = Hex.encodeHex(data);
        assertEquals(2, result.length);
        assertEquals('0', result[0]);
        assertEquals('0', result[1]);
    }

    @Test
    void testEncodeHex_MultipleBytes() {
        byte[] data = new byte[]{0x00, 0xFF};
        char[] result = Hex.encodeHex(data);
        assertEquals(4, result.length);
        assertEquals('0', result[0]);
        assertEquals('0', result[1]);
        assertEquals('f', result[2]);
        assertEquals('f', result[3]);
    }
}
// ```
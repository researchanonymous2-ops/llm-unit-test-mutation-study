package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_COC3Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] data = new byte[0];
        char[] expected = new char[0];
        char[] result = Hex.encodeHex(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_SingleByte() {
        byte[] data = new byte[]{0x0F};
        char[] expected = new char[]{'0', 'f'};
        char[] result = Hex.encodeHex(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] data = new byte[]{0x00, (byte) 0xFF};
        char[] expected = new char[]{'0', '0', 'f', 'f'};
        char[] result = Hex.encodeHex(data);
        assertArrayEquals(expected, result);
    }
}
// ```
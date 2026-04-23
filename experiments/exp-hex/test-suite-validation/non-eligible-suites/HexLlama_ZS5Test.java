package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexLlama_ZS5Test {

    @Test
    public void testEncodeHex_byteArray() {
        byte[] bytes = {0x12, 0x34, 0x56, 0x78};
        char[] expected = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] actual = Hex.encodeHex(bytes);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeHex_charArray() {
        char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8'};
        byte[] expected = {0x12, 0x34, 0x56, 0x78};
        byte[] actual = Hex.decodeHex(chars);
        assertArrayEquals(expected, actual);
    }
}
// ```
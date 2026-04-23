package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HexLlama_ZS1Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] data = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleElementArray() {
        byte[] data = {0x12};
        char[] expected = {'1', '2'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_MultipleElementArray() {
        byte[] data = {0x12, 0x34, (byte) 0xab, (byte) 0xcd};
        char[] expected = {'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_NullArray() {
        assertThrows(NullPointerException.class, () -> Hex.encodeHex(null));
    }
}
// ```
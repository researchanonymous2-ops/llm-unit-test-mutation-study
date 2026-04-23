package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexLlama_OS1Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByte() {
        byte[] input = { 0x0A };
        char[] expected = { '0', 'a' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MultipleBytes() {
        byte[] input = { 0x0A, 0x1B, (byte) 0xC3 };
        char[] expected = { '0', 'a', '1', 'b', 'c', '3' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MinAndMaxByteValues() {
        byte[] input = { (byte) 0x00, (byte) 0xFF };
        char[] expected = { '0', '0', 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_NullInput() {
        try {
            Hex.encodeHex(null);
        } catch (NullPointerException e) {
            // expected
        }
    }
}
// ```
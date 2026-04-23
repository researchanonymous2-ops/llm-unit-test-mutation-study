package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexLlama_OS2Test {

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
        byte[] input = { (byte) 0xFF, 0x00 };
        char[] expected = { 'f', 'f', '0', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_NullInput() {
        assertArrayEquals(null, Hex.encodeHex(null));
    }
}
// ```
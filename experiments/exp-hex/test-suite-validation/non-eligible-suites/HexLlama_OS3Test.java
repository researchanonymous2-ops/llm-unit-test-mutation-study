package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexLlama_OS3Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] input = {};
        char[] expected = {};
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
        byte[] input = { 0x0A, 0x1B, (byte) 0xFF };
        char[] expected = { '0', 'a', '1', 'b', 'f', 'f' };
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
        assertArrayEquals(null, Hex.encodeHex(null));
    }
}
// ```
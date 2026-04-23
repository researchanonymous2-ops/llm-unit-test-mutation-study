package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexLlama_FS1Test {

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
        byte[] input = { 0x00, 0x01, 0x02, 0x03 };
        char[] expected = { '0', '0', '0', '1', '0', '2', '0', '3' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_ZeroByte() {
        byte[] input = { 0x00 };
        char[] expected = { '0', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MaxByte() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MinByte() {
        byte[] input = { (byte) 0x80 };
        char[] expected = { '8', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_Null() {
        byte[] input = null;
        try {
            Hex.encodeHex(input);
        } catch (NullPointerException e) {
            // expected
        }
    }
}
// ```
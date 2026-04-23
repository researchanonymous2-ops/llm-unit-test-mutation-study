package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_FS3Test {

    @Test
    void testEncodeHex_emptyArray() {
        byte[] input = {};
        char[] expected = {};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_singleByteMaxValue() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_singleByteLowerCaseLetter() {
        byte[] input = { 0x0B };
        char[] expected = { '0', 'b' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_multipleBytesMixedValues() {
        byte[] input = { 0x12, (byte) 0xCD, 0x34 };
        char[] expected = { '1', '2', 'c', 'd', '3', '4' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_allZeroBytes() {
        byte[] input = { 0x00, 0x00, 0x00 };
        char[] expected = { '0', '0', '0', '0', '0', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_negativeByteValues() {
        byte[] input = { (byte) 0xA0, (byte) 0xF0 };
        char[] expected = { 'a', '0', 'f', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_alternatingBits() {
        byte[] input = { (byte) 0x55, (byte) 0xAA };
        char[] expected = { '5', '5', 'a', 'a' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
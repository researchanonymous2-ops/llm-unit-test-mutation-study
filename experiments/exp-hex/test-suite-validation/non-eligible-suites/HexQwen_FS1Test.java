package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_FS1Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] input = {};
        char[] expected = {};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByteMaxValue() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MultipleBytesMixedValues() {
        byte[] input = { 0x12, 0x34, 0x56 };
        char[] expected = { '1', '2', '3', '4', '5', '6' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_NegativeByteValue() {
        byte[] input = { (byte) 0x80 };
        char[] expected = { '8', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_AllZeroBits() {
        byte[] input = { 0x00, 0x00, 0x00 };
        char[] expected = { '0', '0', '0', '0', '0', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_UppercaseLetterBytes() {
        byte[] input = { 0xAB, 0xCD, 0xEF };
        char[] expected = { 'a', 'b', 'c', 'd', 'e', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByteLowNibbleOnly() {
        byte[] input = { 0x0F };
        char[] expected = { '0', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByteHighNibbleOnly() {
        byte[] input = { (byte) 0xF0 };
        char[] expected = { 'f', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
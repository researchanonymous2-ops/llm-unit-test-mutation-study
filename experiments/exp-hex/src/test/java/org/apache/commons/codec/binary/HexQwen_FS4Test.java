package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_FS4Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] input = {};
        char[] expected = {};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MaximumByteValue() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MultipleBytesWithAllDigitCombinations() {
        byte[] input = { 0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0 };
        char[] expected = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByteLowerCaseLetter() {
        byte[] input = { 0x0B };
        char[] expected = { '0', 'b' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_NegativeByteValue() {
        byte[] input = { (byte) 0x80 };
        char[] expected = { '8', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MixOfPositiveAndNegativeBytes() {
        byte[] input = { 0x01, (byte) 0xFE, 0x02, (byte) 0xFD };
        char[] expected = { '0', '1', 'f', 'e', '0', '2', 'f', 'd' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
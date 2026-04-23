package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_OS3Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] input = {};
        char[] expected = {};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleZeroByte() {
        byte[] input = { 0x00 };
        char[] expected = { '0', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleMaxByte() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MixedBytes() {
        byte[] input = { 0x12, (byte) 0xAB, 0x3C };
        char[] expected = { '1', '2', 'a', 'b', '3', 'c' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_NegativeByteValues() {
        byte[] input = { (byte) 0x80, (byte) 0x9F };
        char[] expected = { '8', '0', '9', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_AllDigitCombinations() {
        byte[] input = { 0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
        char[] expected = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
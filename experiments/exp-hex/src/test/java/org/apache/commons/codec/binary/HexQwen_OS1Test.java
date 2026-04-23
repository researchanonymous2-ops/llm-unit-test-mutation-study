package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

public class HexQwen_OS1Test {

    @Test
    void testEncodeHex_EmptyArray() {
        byte[] input = {};
        char[] expected = {};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByteZero() {
        byte[] input = { 0x00 };
        char[] expected = { '0', '0' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_SingleByteMax() {
        byte[] input = { (byte) 0xFF };
        char[] expected = { 'f', 'f' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MultipleBytes() {
        byte[] input = { 0x12, 0x34, 0x56 };
        char[] expected = { '1', '2', '3', '4', '5', '6' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_NegativeByte() {
        byte[] input = { (byte) 0xAB };
        char[] expected = { 'a', 'b' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    void testEncodeHex_MixedPositiveAndNegative() {
        byte[] input = { 0x0F, (byte) 0xF0, 0x78, (byte) 0x87 };
        char[] expected = { '0', 'f', 'f', '0', '7', '8', '8', '7' };
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
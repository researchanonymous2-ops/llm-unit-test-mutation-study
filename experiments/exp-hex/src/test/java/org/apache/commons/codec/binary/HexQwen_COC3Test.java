package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexQwen_COC3Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = {};
        char[] expected = {};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_singleByteZero() {
        byte[] input = {0};
        char[] expected = {'0', '0'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_singleByteMax() {
        byte[] input = {(byte) 0xFF};
        char[] expected = {'f', 'f'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = {0x12, 0x34, (byte) 0xAB, (byte) 0xCD};
        char[] expected = {'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_negativeBytes() {
        byte[] input = {(byte) 0x80, (byte) 0x9A, (byte) 0xFB};
        char[] expected = {'8', '0', '9', 'a', 'f', 'b'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }
}
// ```
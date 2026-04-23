package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexQwen_COC5Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = {};
        char[] expected = {};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_singleByteZero() {
        byte[] input = {0};
        char[] expected = {'0', '0'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_singleByteMax() {
        byte[] input = {(byte) 0xFF};
        char[] expected = {'f', 'f'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = {0x12, 0x34, (byte) 0xAB, (byte) 0xCD};
        char[] expected = {'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }
}
// ```
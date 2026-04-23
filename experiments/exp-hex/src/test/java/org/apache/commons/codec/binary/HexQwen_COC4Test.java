package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexQwen_COC4Test {

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
        byte[] input = {0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0};
        char[] expected = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', '0'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }
}
// ```
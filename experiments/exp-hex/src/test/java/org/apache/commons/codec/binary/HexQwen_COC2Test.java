package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexQwen_COC2Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_singleByteZero() {
        byte[] input = new byte[]{0x00};
        char[] expected = new char[]{'0', '0'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_singleByteMax() {
        byte[] input = new byte[]{(byte) 0xFF};
        char[] expected = new char[]{'f', 'f'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF};
        char[] expected = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_mixedValues() {
        byte[] input = new byte[]{(byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78, (byte) 0x90};
        char[] expected = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }
}
// ```
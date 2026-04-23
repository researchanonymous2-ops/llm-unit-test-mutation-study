package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexQwen_ZS3Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleZeroByte() {
        byte[] input = new byte[]{0};
        char[] expected = {'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleNonZeroByte() {
        byte[] input = new byte[]{15};
        char[] expected = {'0', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleByteMaxValue() {
        byte[] input = new byte[]{(byte) 255};
        char[] expected = {'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = new byte[]{0, 15, (byte) 255};
        char[] expected = {'0', '0', '0', 'f', 'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_negativeByteValues() {
        byte[] input = new byte[]{(byte) 128, (byte) 255, (byte) 127};
        char[] expected = {'8', '0', 'f', 'f', '7', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_allHexDigits() {
        byte[] input = new byte[]{0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef};
        char[] expected = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
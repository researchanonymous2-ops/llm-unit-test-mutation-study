package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexQwen_ZS4Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleZeroByte() {
        byte[] input = new byte[]{0};
        char[] expected = new char[]{'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleNonZeroByte() {
        byte[] input = new byte[]{15};
        char[] expected = new char[]{'0', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleByteMaxValue() {
        byte[] input = new byte[]{(byte) 255};
        char[] expected = new char[]{'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = new byte[]{0, 15, (byte) 255};
        char[] expected = new char[]{'0', '0', '0', 'f', 'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_negativeByteValues() {
        byte[] input = new byte[]{(byte) 128, (byte) 255, (byte) 129};
        char[] expected = new char[]{'8', '0', 'f', 'f', '8', '1'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_allHexDigits() {
        byte[] input = new byte[]{0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0};
        char[] expected = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
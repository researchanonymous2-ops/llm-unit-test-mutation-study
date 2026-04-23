package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexGrok_ZS2Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteZero() {
        byte[] input = new byte[]{0};
        char[] expected = new char[]{'0', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteOne() {
        byte[] input = new byte[]{1};
        char[] expected = new char[]{'0', '1'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteFifteen() {
        byte[] input = new byte[]{15};
        char[] expected = new char[]{'0', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteSixteen() {
        byte[] input = new byte[]{16};
        char[] expected = new char[]{'1', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteMax() {
        byte[] input = new byte[]{127};
        char[] expected = new char[]{'7', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteMin() {
        byte[] input = new byte[]{-128};
        char[] expected = new char[]{'8', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteNegativeOne() {
        byte[] input = new byte[]{-1};
        char[] expected = new char[]{'f', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] input = new byte[]{0, 1, 15, 16, 127, -128, -1};
        char[] expected = new char[]{'0', '0', '0', '1', '0', 'f', '1', '0', '7', 'f', '8', '0', 'f', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_LargeArray() {
        byte[] input = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        char[] expected = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'a', '0', 'b', '0', 'c', '0', 'd', '0', 'e', '0', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(input));
    }
}
// ```
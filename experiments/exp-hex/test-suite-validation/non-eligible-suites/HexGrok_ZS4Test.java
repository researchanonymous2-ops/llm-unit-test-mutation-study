package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_ZS4Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteZero() {
        byte[] input = new byte[]{0};
        char[] expected = new char[]{'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleBytePositive() {
        byte[] input = new byte[]{15};
        char[] expected = new char[]{'0', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteMax() {
        byte[] input = new byte[]{127};
        char[] expected = new char[]{'7', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteNegative() {
        byte[] input = new byte[]{-1};
        char[] expected = new char[]{'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByteMin() {
        byte[] input = new byte[]{-128};
        char[] expected = new char[]{'8', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] input = new byte[]{0, 1, 15, 127, -1, -128};
        char[] expected = new char[]{'0', '0', '0', '1', '0', 'f', '7', 'f', 'f', 'f', '8', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_VariousBytes() {
        byte[] input = new byte[]{10, 255, -10};
        char[] expected = new char[]{'0', 'a', 'f', 'f', 'f', '6'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
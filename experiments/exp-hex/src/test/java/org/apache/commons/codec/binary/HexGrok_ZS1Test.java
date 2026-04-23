package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexGrok_ZS1Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] data = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteZero() {
        byte[] data = new byte[]{0};
        char[] expected = new char[]{'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteOne() {
        byte[] data = new byte[]{1};
        char[] expected = new char[]{'0', '1'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteFifteen() {
        byte[] data = new byte[]{15};
        char[] expected = new char[]{'0', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteSixteen() {
        byte[] data = new byte[]{16};
        char[] expected = new char[]{'1', '0'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteMax() {
        byte[] data = new byte[]{127};
        char[] expected = new char[]{'7', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteMin() {
        byte[] data = new byte[]{-128};
        char[] expected = new char[]{'8', '0'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteNegativeOne() {
        byte[] data = new byte[]{-1};
        char[] expected = new char[]{'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] data = new byte[]{0, 1, 15, 16, 127, -128, -1};
        char[] expected = new char[]{'0', '0', '0', '1', '0', 'f', '1', '0', '7', 'f', '8', '0', 'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }
}
// ```
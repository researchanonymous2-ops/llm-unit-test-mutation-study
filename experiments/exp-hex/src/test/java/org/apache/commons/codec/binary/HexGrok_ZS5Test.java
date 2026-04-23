package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_ZS5Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] data = {};
        char[] expected = {};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteZero() {
        byte[] data = {0};
        char[] expected = {'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteOne() {
        byte[] data = {1};
        char[] expected = {'0', '1'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteFifteen() {
        byte[] data = {15};
        char[] expected = {'0', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteSixteen() {
        byte[] data = {16};
        char[] expected = {'1', '0'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteMax() {
        byte[] data = {(byte) 255};
        char[] expected = {'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_NegativeByte() {
        byte[] data = {-1};
        char[] expected = {'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] data = {0, 1, 15, 16, (byte) 255};
        char[] expected = {'0', '0', '0', '1', '0', 'f', '1', '0', 'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_AllNibbles() {
        byte[] data = {(byte) 0xAB, (byte) 0xCD, (byte) 0xEF};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(data));
    }
}
// ```
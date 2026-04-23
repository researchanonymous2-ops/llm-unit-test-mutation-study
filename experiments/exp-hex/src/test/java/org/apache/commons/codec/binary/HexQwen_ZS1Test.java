package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexQwen_ZS1Test {

    @Test
    public void testEncodeHex_emptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleZeroByte() {
        byte[] input = {0};
        char[] expected = {'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleByteFF() {
        byte[] input = {(byte) 0xFF};
        char[] expected = {'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleByte0F() {
        byte[] input = {0x0F};
        char[] expected = {'0', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_singleByteF0() {
        byte[] input = {(byte) 0xF0};
        char[] expected = {'f', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_multipleBytes() {
        byte[] input = {0x12, 0x34, (byte) 0xAB, (byte) 0xCD};
        char[] expected = {'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_negativeBytes() {
        byte[] input = {(byte) 0x80, (byte) 0x9A, (byte) 0xFF};
        char[] expected = {'8', '0', '9', 'a', 'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_mixedBytes() {
        byte[] input = {0x00, 0x01, 0x7F, (byte) 0x80, (byte) 0xFF};
        char[] expected = {'0', '0', '0', '1', '7', 'f', '8', '0', 'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
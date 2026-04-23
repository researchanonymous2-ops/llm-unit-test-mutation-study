package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_ZS5Test {

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_nullArray() {
        byte[] input = null;
        byte[] expected = new byte[0];
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_singleZeroByte() {
        byte[] input = {0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_singleOneByte() {
        byte[] input = {-1};
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_mixedBits() {
        byte[] input = {5}; // 00000101
        byte[] expected = {'0', '0', '0', '0', '0', '1', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = {3, 5}; // 00000011, 00000101
        byte[] expected = {'0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '1', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_allBytes() {
        byte[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(128, result.length);
        // Check first byte (0 = 00000000)
        assertEquals('0', result[0]);
        assertEquals('0', result[1]);
        assertEquals('0', result[2]);
        assertEquals('0', result[3]);
        assertEquals('0', result[4]);
        assertEquals('0', result[5]);
        assertEquals('0', result[6]);
        assertEquals('0', result[7]);
        // Check second byte (1 = 00000001)
        assertEquals('0', result[8]);
        assertEquals('0', result[9]);
        assertEquals('0', result[10]);
        assertEquals('0', result[11]);
        assertEquals('0', result[12]);
        assertEquals('0', result[13]);
        assertEquals('0', result[14]);
        assertEquals('1', result[15]);
    }
}
// ```
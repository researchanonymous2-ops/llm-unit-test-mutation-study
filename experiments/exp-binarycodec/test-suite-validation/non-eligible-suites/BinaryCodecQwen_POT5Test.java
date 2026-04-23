package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_POT5Test {

    @Test
    public void testToAsciiBytes_nullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] input = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToAsciiBytes_singleByteAllZeros() {
        byte[] input = {0}; // 00000000
        byte[] expected = "00000000".getBytes();
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_singleByteAllOnes() {
        byte[] input = {-1}; // 11111111 (all bits set)
        byte[] expected = "11111111".getBytes();
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_singleByteMixed() {
        byte[] input = {5}; // 00000101
        byte[] expected = "00000101".getBytes();
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = {0, -1}; // 00000000 11111111
        byte[] expected = "0000000011111111".getBytes();
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_multipleBytesMixed() {
        byte[] input = {3, 6, 12}; // 00000011 00000110 00001100
        byte[] expected = "000000110000011000001100".getBytes();
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }
}
// ```
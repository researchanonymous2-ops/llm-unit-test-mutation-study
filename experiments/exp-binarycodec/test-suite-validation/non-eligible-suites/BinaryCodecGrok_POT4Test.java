package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_POT4Test {

    @Test
    public void testToAsciiBytes_NullOrEmptyInput() {
        // Test for null input
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, BinaryCodec.toAsciiBytes(null));
        
        // Test for empty array
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    public void testToAsciiBytes_SingleByteAllZeros() {
        byte[] raw = {0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    public void testToAsciiBytes_SingleByteAllOnes() {
        byte[] raw = {(byte) 255};
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    public void testToAsciiBytes_SingleByteMixedBits() {
        byte[] raw = {85}; // 01010101 in binary
        byte[] expected = {'0', '1', '0', '1', '0', '1', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    public void testToAsciiBytes_MultipleBytes() {
        byte[] raw = {0, (byte) 255};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    public void testToAsciiBytes_LargerInput() {
        byte[] raw = {1, 2, 4};
        byte[] result = BinaryCodec.toAsciiBytes(raw);
        assertEquals(24, result.length); // 8 * 3
        // Additional checks can be added for specific bit patterns if needed
    }
}
// ```
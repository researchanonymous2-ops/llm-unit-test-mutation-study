package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecGrok_POT1Test {

    @Test
    void testToAsciiBytes_NullInput() {
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, BinaryCodec.toAsciiBytes(null));
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    void testToAsciiBytes_SingleByteAllZeros() {
        byte[] raw = {(byte) 0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    void testToAsciiBytes_SingleByteWithOnes() {
        byte[] raw = {(byte) 255}; // All bits set
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    void testToAsciiBytes_SingleByteMixed() {
        byte[] raw = {(byte) 1}; // Only least significant bit set
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] raw = {(byte) 0, (byte) 1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(raw));
    }
}
// ```
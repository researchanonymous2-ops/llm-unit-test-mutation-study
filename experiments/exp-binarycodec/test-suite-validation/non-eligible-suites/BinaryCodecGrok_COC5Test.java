package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_COC5Test {

    @Test
    void testToAsciiBytes_NullInput() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(null));
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    void testToAsciiBytes_SingleByteZero() {
        byte[] input = {0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_SingleByteOne() {
        byte[] input = {1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_SingleByteAllOnes() {
        byte[] input = {(byte) 255};
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = {0, 1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }
}
// ```
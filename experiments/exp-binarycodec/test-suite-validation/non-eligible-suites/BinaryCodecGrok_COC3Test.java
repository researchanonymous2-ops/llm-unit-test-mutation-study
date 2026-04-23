package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_COC3Test {

    @Test
    void testToAsciiBytes_NullInput() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(null));
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    void testToAsciiBytes_SingleByteAllZeros() {
        byte[] input = {0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_SingleByteBit0Set() {
        byte[] input = {1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_SingleByteBit7Set() {
        byte[] input = {(byte) 0x80};
        byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_SingleByteMixedBits() {
        byte[] input = {(byte) 0b10101010};
        byte[] expected = {'1', '0', '1', '0', '1', '0', '1', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_TwoBytes() {
        byte[] input = {0, 1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }
}
// ```
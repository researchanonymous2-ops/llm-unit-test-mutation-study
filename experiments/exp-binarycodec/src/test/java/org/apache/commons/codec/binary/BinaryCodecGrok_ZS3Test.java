package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_ZS3Test {

    @Test
    public void testToAsciiBytes_NullInput() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(null));
    }

    @Test
    public void testToAsciiBytes_EmptyArray() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    public void testToAsciiBytes_SingleByteZero() {
        byte[] input = {0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_SingleByteOne() {
        byte[] input = {1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_SingleByteMax() {
        byte[] input = {(byte) 255};
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_SingleByteMin() {
        byte[] input = {(byte) -128};
        byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_MultipleBytes() {
        byte[] input = {0, 1};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }
}
// ```
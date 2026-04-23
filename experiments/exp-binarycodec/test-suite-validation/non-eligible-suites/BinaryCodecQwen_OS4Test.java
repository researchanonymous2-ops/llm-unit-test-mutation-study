package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_OS4Test {

    @Test
    void testToAsciiBytes_NullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testToAsciiBytes_EmptyInput() {
        byte[] result = BinaryCodec.toAsciiBytes(new byte[0]);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testToAsciiBytes_SingleZeroByte() {
        byte[] input = {0x00};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_SingleOneByte() {
        byte[] input = {(byte) 0xFF};
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MixedBits() {
        byte[] input = {(byte) 0b10101010};
        byte[] expected = {'1', '0', '1', '0', '1', '0', '1', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_TwoBytes() {
        byte[] input = {0x0F, (byte) 0xF0};
        byte[] expected = {'0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MaxValueByte() {
        byte[] input = {(byte) 0x80};
        byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MinValueByte() {
        byte[] input = {(byte) 0x7F};
        byte[] expected = {'0', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_NegativeByte() {
        byte[] input = {(byte) 0x81};
        byte[] expected = {'1', '0', '0', '0', '0', '0', '0', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_LargeArray() {
        byte[] input = {0x01, 0x02, 0x03, 0x04};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '1', 
                          '0', '0', '0', '0', '0', '0', '1', '0',
                          '0', '0', '0', '0', '0', '0', '1', '1',
                          '0', '0', '0', '0', '0', '1', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }
}
// ```
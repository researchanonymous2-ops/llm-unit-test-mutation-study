package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_COC2Test {

    @Test
    public void testToAsciiBytes_nullInput() {
        byte[] input = null;
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertSame(BinaryCodec.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] input = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertSame(BinaryCodec.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToAsciiBytes_singleZeroByte() {
        byte[] input = new byte[]{0};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = "00000000".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_singleNonZeroByte() {
        byte[] input = new byte[]{1};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = "00000001".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_singleMaxByte() {
        byte[] input = new byte[]{-1}; // 0xFF or 11111111 in binary
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = "11111111".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = new byte[]{0, 1, -1};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = "000000000000000111111111".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_mixedBits() {
        byte[] input = new byte[]{0b10101010};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = "10101010".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_allBytesPattern() {
        byte[] input = new byte[]{0b11110000, 0b00001111};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = "1111000000001111".getBytes();
        assertArrayEquals(expected, result);
    }
}
// ```
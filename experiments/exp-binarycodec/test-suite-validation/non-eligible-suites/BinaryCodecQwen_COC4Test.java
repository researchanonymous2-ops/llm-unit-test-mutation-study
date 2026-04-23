package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_COC4Test {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Test
    public void testToAsciiBytes_nullInput() {
        byte[] input_raw = null;
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        assertArrayEquals(EMPTY_BYTE_ARRAY, observable_return);
    }

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] input_raw = new byte[0];
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        assertArrayEquals(EMPTY_BYTE_ARRAY, observable_return);
    }

    @Test
    public void testToAsciiBytes_singleZeroByte() {
        byte[] input_raw = new byte[]{0};
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "00000000".getBytes();
        assertArrayEquals(expected, observable_return);
    }

    @Test
    public void testToAsciiBytes_singleOneByte() {
        byte[] input_raw = new byte[]{1};
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "00000001".getBytes();
        assertArrayEquals(expected, observable_return);
    }

    @Test
    public void testToAsciiBytes_singleMaxByte() {
        byte[] input_raw = new byte[]{-1}; // 0xFF or 11111111 in binary
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "11111111".getBytes();
        assertArrayEquals(expected, observable_return);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input_raw = new byte[]{1, 2, 3};
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "000000010000001000000011".getBytes();
        assertArrayEquals(expected, observable_return);
    }

    @Test
    public void testToAsciiBytes_mixedBits() {
        byte[] input_raw = new byte[]{0b10101010, 0b01010101};
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "1010101001010101".getBytes();
        assertArrayEquals(expected, observable_return);
    }
}
// ```
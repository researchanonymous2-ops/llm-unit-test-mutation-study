package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_COC3Test {

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
        byte[] input_raw = new byte[]{-1}; // all bits set (11111111)
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "11111111".getBytes();
        assertArrayEquals(expected, observable_return);
    }

    @Test
    public void testToAsciiBytes_mixedBits() {
        byte[] input_raw = new byte[]{5, 10}; // 00000101, 00001010
        byte[] observable_return = BinaryCodec.toAsciiBytes(input_raw);
        byte[] expected = "0000010100001010".getBytes();
        assertArrayEquals(expected, observable_return);
    }
}
// ```
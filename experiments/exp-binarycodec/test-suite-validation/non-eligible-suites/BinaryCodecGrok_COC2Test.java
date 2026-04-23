package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_COC2Test {

    @Test
    public void testToAsciiBytes_NullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToAsciiBytes_EmptyArray() {
        byte[] result = BinaryCodec.toAsciiBytes(new byte[0]);
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testToAsciiBytes_SingleByteAllZeros() {
        byte[] input = new byte[]{0};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_SingleByteAllOnes() {
        byte[] input = new byte[]{(byte) 255};
        byte[] expected = new byte[]{'1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_SingleByteMixed() {
        byte[] input = new byte[]{1}; // 00000001
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_MultipleBytes() {
        byte[] input = new byte[]{0, (byte) 255};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }
}
// ```
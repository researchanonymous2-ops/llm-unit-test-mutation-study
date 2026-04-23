package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecGrok_COC1Test {

    @Test
    void testToAsciiBytes_NullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        byte[] result = BinaryCodec.toAsciiBytes(new byte[0]);
        assertArrayEquals(BinaryCodec.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    void testToAsciiBytes_SingleByteAllZeros() {
        byte[] raw = new byte[]{0};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(raw);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_SingleByteAllOnes() {
        byte[] raw = new byte[]{-1};
        byte[] expected = new byte[]{'1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(raw);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_SingleByteMixed() {
        byte[] raw = new byte[]{85}; // 01010101
        byte[] expected = new byte[]{'0', '1', '0', '1', '0', '1', '0', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(raw);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] raw = new byte[]{0, -1};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(raw);
        assertArrayEquals(expected, result);
    }
}
// ```
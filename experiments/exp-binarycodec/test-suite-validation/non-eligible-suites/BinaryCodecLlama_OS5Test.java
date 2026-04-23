package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecLlama_OS5Test {

    @Test
    void testToAsciiBytes_NullInput() {
        byte[] input = null;
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        byte[] input = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testToAsciiBytes_SingleByte() {
        byte[] input = { 0x01 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = { 0x01, 0x02 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_CheckNotNull() {
        byte[] input = { 0x01 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
    }

    @Test
    void testToAsciiBytes_CheckLength() {
        byte[] input = { 0x01, 0x02 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(input.length * 8, result.length);
    }
}
// ```
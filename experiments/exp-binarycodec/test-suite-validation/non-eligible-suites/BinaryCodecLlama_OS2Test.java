package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecLlama_OS2Test {

    @Test
    void testToAsciiBytes_NullInput() {
        byte[] input = null;
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        byte[] input = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testToAsciiBytes_SingleByte() {
        byte[] input = { 0x01 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = { 0x01, 0x02 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MaxByteValue() {
        byte[] input = { (byte) 0xFF };
        byte[] expected = { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToAsciiBytes_MinByteValue() {
        byte[] input = { (byte) 0x00 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '0' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertArrayEquals(expected, result);
    }
}
// ```
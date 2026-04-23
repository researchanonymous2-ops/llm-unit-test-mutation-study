package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecLlama_OS4Test {

    @Test
    void testToAsciiBytes_NullInput() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(null));
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    void testToAsciiBytes_SingleByte() {
        byte[] input = { 0x01 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1' };
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = { 0x01, 0x02 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_AllBitsSet() {
        byte[] input = { (byte) 0xFF };
        byte[] expected = { '1', '1', '1', '1', '1', '1', '1', '1' };
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_NoBitsSet() {
        byte[] input = { 0x00 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '0' };
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    void testToAsciiBytes_ResultNotNull() {
        byte[] input = { 0x01 };
        assertNotNull(BinaryCodec.toAsciiBytes(input));
    }
}
// ```
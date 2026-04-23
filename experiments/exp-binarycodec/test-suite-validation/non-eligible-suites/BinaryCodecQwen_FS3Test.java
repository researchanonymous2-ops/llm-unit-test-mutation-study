package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_FS3Test {

    @Test
    void testToAsciiBytes_nullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testToAsciiBytes_emptyArray() {
        byte[] input = {};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testToAsciiBytes_singleZeroByte() {
        byte[] input = { 0x00 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals("00000000", new String(result));
    }

    @Test
    void testToAsciiBytes_singleMaxByte() {
        byte[] input = { (byte) 0xFF };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals("11111111", new String(result));
    }

    @Test
    void testToAsciiBytes_mixedBits() {
        byte[] input = { (byte) 0xA5 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals("10100101", new String(result));
    }

    @Test
    void testToAsciiBytes_multipleBytes() {
        byte[] input = { (byte) 0x0F, (byte) 0xF0 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(16, result.length);
        assertEquals("0000111111110000", new String(result));
    }

    @Test
    void testToAsciiBytes_alternatingPattern() {
        byte[] input = { (byte) 0xAA, (byte) 0x55 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(16, result.length);
        assertEquals("1010101001010101", new String(result));
    }

    @Test
    void testToAsciiBytes_allBytesRange() {
        byte[] input = new byte[256];
        for (int i = 0; i < 256; i++) {
            input[i] = (byte) i;
        }
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(256 * 8, result.length);
    }
}
// ```
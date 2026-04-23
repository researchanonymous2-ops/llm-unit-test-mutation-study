package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecQwen_FS4Test {

    @Test
    void testToAsciiBytes_withNullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testToAsciiBytes_withEmptyArray() {
        byte[] input = {};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testToAsciiBytes_withSingleZeroByte() {
        byte[] input = { 0x00 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals("00000000", new String(result));
    }

    @Test
    void testToAsciiBytes_withSingleMaxByte() {
        byte[] input = { (byte) 0xFF };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals("11111111", new String(result));
    }

    @Test
    void testToAsciiBytes_withMixedBitsByte() {
        byte[] input = { 0x5A }; // 01011010
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals("01011010", new String(result));
    }

    @Test
    void testToAsciiBytes_withMultipleBytes() {
        byte[] input = { 0x00, (byte) 0xFF, 0x5A };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(24, result.length);
        assertEquals("000000001111111101011010", new String(result));
    }

    @Test
    void testToAsciiBytes_withSingleBitPatterns() {
        byte[] input = { 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, (byte) 0x80 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(64, result.length);
        assertEquals("0000000100000010000001000000100000010000001000000100000010000000", new String(result));
    }

    @Test
    void testToAsciiBytes_withNegativeBytes() {
        byte[] input = { (byte) 0x80, (byte) 0xC0, (byte) 0xE0 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(24, result.length);
        assertEquals("100000001100000011100000", new String(result));
    }
}
// ```
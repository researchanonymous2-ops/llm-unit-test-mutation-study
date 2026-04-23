package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecLlama_FS3Test {

    @Test
    void testToAsciiBytes_NullInput() {
        byte[] input = null;
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(0, result.length);
    }

    @Test
    void testToAsciiBytes_EmptyArray() {
        byte[] input = {};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(0, result.length);
    }

    @Test
    void testToAsciiBytes_SingleByte() {
        byte[] input = { 0x01 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals('0', result[0]);
        assertEquals('0', result[1]);
        assertEquals('0', result[2]);
        assertEquals('0', result[3]);
        assertEquals('0', result[4]);
        assertEquals('0', result[5]);
        assertEquals('0', result[6]);
        assertEquals('1', result[7]);
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = { 0x0F, (byte) 0xA5 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(16, result.length);
        assertEquals('0', result[0]);
        assertEquals('0', result[1]);
        assertEquals('0', result[2]);
        assertEquals('0', result[3]);
        assertEquals('1', result[4]);
        assertEquals('1', result[5]);
        assertEquals('1', result[6]);
        assertEquals('1', result[7]);
        assertEquals('1', result[8]);
        assertEquals('0', result[9]);
        assertEquals('1', result[10]);
        assertEquals('0', result[11]);
        assertEquals('0', result[12]);
        assertEquals('0', result[13]);
        assertEquals('1', result[14]);
        assertEquals('0', result[15]);
    }

    @Test
    void testToAsciiBytes_AllBitsSet() {
        byte[] input = { (byte) 0xFF };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals('1', result[0]);
        assertEquals('1', result[1]);
        assertEquals('1', result[2]);
        assertEquals('1', result[3]);
        assertEquals('1', result[4]);
        assertEquals('1', result[5]);
        assertEquals('1', result[6]);
        assertEquals('1', result[7]);
    }

    @Test
    void testToAsciiBytes_NoBitsSet() {
        byte[] input = { 0x00 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertEquals('0', result[0]);
        assertEquals('0', result[1]);
        assertEquals('0', result[2]);
        assertEquals('0', result[3]);
        assertEquals('0', result[4]);
        assertEquals('0', result[5]);
        assertEquals('0', result[6]);
        assertEquals('0', result[7]);
    }
}
// ```
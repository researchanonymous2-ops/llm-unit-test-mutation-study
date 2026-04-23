package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;

public class BinaryCodecLlama_FS2Test {

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
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1' };
        assertEquals(expected.length, result.length);
        assertEquals(new String(expected), new String(result));
    }

    @Test
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = { 0x0F, (byte) 0xA5 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        byte[] expected = { '0', '0', '0', '0', '1', '1', '1', '1', '1', '0', '1', '0', '0', '1', '0', '1' };
        assertEquals(expected.length, result.length);
        assertEquals(new String(expected), new String(result));
    }

    @Test
    void testToAsciiBytes_CheckContents() {
        byte[] input = { (byte) 0xFF };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        for (int i = 0; i < 8; i++) {
            assertEquals('1', result[i]);
        }
    }
}
// ```
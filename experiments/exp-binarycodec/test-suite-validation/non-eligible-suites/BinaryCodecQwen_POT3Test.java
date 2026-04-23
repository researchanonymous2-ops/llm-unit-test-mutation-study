package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_POT3Test {

    @Test
    public void testToAsciiBytes_nullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] input = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToAsciiBytes_singleZeroByte() {
        byte[] input = {0};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertArrayEquals(new byte[]{'0','0','0','0','0','0','0','0'}, result);
    }

    @Test
    public void testToAsciiBytes_singleNonZeroByte() {
        byte[] input = {1};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertArrayEquals(new byte[]{'0','0','0','0','0','0','0','1'}, result);
    }

    @Test
    public void testToAsciiBytes_singleByteWithAllBitsSet() {
        byte[] input = {(byte) 0xFF};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertArrayEquals(new byte[]{'1','1','1','1','1','1','1','1'}, result);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = {0, 1};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(16, result.length);
        assertArrayEquals(new byte[]{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','1'}, result);
    }

    @Test
    public void testToAsciiBytes_mixedBitPattern() {
        byte[] input = {(byte) 0xA5, (byte) 0x3C}; // 10100101 00111100
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(16, result.length);
        assertArrayEquals(new byte[]{'1','0','1','0','0','1','0','1','0','0','1','1','1','1','0','0'}, result);
    }
}
// ```
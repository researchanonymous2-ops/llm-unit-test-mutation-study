package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_POT2Test {

    private final BinaryCodec codec = new BinaryCodec();

    @Test
    public void testToAsciiBytes_nullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertEquals(0, result.length);
    }

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] result = BinaryCodec.toAsciiBytes(new byte[0]);
        assertEquals(0, result.length);
    }

    @Test
    public void testToAsciiBytes_singleByteZero() {
        byte[] input = {0};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        assertArrayEquals("00000000".getBytes(), result);
    }

    @Test
    public void testToAsciiBytes_singleByteAllOnes() {
        byte[] input = {-1}; // 11111111 in binary
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        assertArrayEquals("11111111".getBytes(), result);
    }

    @Test
    public void testToAsciiBytes_singleByteMixed() {
        byte[] input = {5}; // 00000101 in binary
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        assertArrayEquals("00000101".getBytes(), result);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = {5, -1, 0}; // 00000101 11111111 00000000
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(24, result.length);
        assertArrayEquals("000001011111111100000000".getBytes(), result);
    }
}
// ```
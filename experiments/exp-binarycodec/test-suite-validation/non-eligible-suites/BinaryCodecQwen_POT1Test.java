package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_POT1Test {

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
    public void testToAsciiBytes_singleByteAllZeros() {
        byte[] input = new byte[]{0b00000000}; // 0
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertArrayEquals(new byte[]{'0','0','0','0','0','0','0','0'}, result);
    }

    @Test
    public void testToAsciiBytes_singleByteAllOnes() {
        byte[] input = new byte[]{(byte)0b11111111}; // 255
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertArrayEquals(new byte[]{'1','1','1','1','1','1','1','1'}, result);
    }

    @Test
    public void testToAsciiBytes_singleByteMixed() {
        byte[] input = new byte[]{0b10101010};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(8, result.length);
        assertArrayEquals(new byte[]{'1','0','1','0','1','0','1','0'}, result);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = new byte[]{0b11001100, 0b00110011};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(16, result.length);
        assertArrayEquals(new byte[]{'1','1','0','0','1','1','0','0','0','0','1','1','0','0','1','1'}, result);
    }
}
// ```
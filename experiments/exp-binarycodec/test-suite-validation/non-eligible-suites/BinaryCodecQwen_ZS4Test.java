package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import org.apache.commons.codec.binary.BinaryCodec;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_ZS4Test {

    @Test
    public void testToAsciiBytes_emptyArray() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_nullInput() {
        byte[] input = null;
        byte[] expected = new byte[0];
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_singleZeroByte() {
        byte[] input = {0};
        byte[] expected = {'0', '0', '0', '0', '0', '0', '0', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_singleOneByte() {
        byte[] input = {-1};
        byte[] expected = {'1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_mixedBits() {
        byte[] input = {0b10101010};
        byte[] expected = {'1', '0', '1', '0', '1', '0', '1', '0'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = {0b11110000, 0b00001111};
        byte[] expected = {'1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1'};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_allBytes() {
        byte[] input = new byte[256];
        for (int i = 0; i < 256; i++) {
            input[i] = (byte) i;
        }
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(256 * 8, result.length);
        
        // Check first byte (0) -> 00000000
        assertArrayEquals(new byte[]{'0','0','0','0','0','0','0','0'}, 
                          java.util.Arrays.copyOfRange(result, 0, 8));
        
        // Check last byte (255) -> 11111111
        assertArrayEquals(new byte[]{'1','1','1','1','1','1','1','1'}, 
                          java.util.Arrays.copyOfRange(result, result.length - 8, result.length));
    }
}
// ```
package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_ZS1Test {

    private final BinaryCodec codec = new BinaryCodec();

    @Test
    public void testToAsciiBytes_emptyArray() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(new byte[0]));
    }

    @Test
    public void testToAsciiBytes_nullInput() {
        assertArrayEquals(new byte[0], BinaryCodec.toAsciiBytes(null));
    }

    @Test
    public void testToAsciiBytes_singleZeroByte() {
        byte[] input = {0};
        byte[] expected = "00000000".getBytes();
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_singleOneByte() {
        byte[] input = {-1}; // all bits set to 1
        byte[] expected = "11111111".getBytes();
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_mixedBits() {
        byte[] input = {0b10101010};
        byte[] expected = "10101010".getBytes();
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_multipleBytes() {
        byte[] input = {0b11001100, 0b00110011};
        byte[] expected = "1100110000110011".getBytes();
        assertArrayEquals(expected, BinaryCodec.toAsciiBytes(input));
    }

    @Test
    public void testToAsciiBytes_allPossibleBytes() {
        byte[] input = new byte[256];
        for (int i = 0; i < 256; i++) {
            input[i] = (byte) i;
        }
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(256 * 8, result.length);
        
        // Check first byte (0) -> "00000000"
        for (int i = 0; i < 8; i++) {
            assertEquals('0', result[i]);
        }
        
        // Check second byte (1) -> "00000001"
        assertEquals('0', result[8]);
        assertEquals('0', result[9]);
        assertEquals('0', result[10]);
        assertEquals('0', result[11]);
        assertEquals('0', result[12]);
        assertEquals('0', result[13]);
        assertEquals('0', result[14]);
        assertEquals('1', result[15]);
    }
}
// ```
package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecLlama_ZS2Test {

    @Test
    public void testToAsciiBytes_NullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testToAsciiBytes_EmptyArray() {
        byte[] result = BinaryCodec.toAsciiBytes(new byte[0]);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testToAsciiBytes_SingleByte() {
        byte[] input = { (byte) 0x01 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_MultipleBytes() {
        byte[] input = { (byte) 0x01, (byte) 0x02 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_AllBitsSet() {
        byte[] input = { (byte) 0xFF };
        byte[] expected = { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_NoBitsSet() {
        byte[] input = { (byte) 0x00 };
        byte[] expected = { '0', '0', '0', '0', '0', '0', '0', '0' };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, result);
    }
}
// ```
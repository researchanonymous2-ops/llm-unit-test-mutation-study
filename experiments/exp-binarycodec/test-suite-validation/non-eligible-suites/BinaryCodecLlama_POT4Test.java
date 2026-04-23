package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecLlama_POT4Test {

    @Test
    public void testToAsciiBytes_NullInput() {
        byte[] input = null;
        byte[] expected = new byte[0];
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_EmptyArray() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_SingleByte() {
        byte[] input = { (byte) 0x01 };
        byte[] expected = new byte[] { '0', '0', '0', '0', '0', '0', '0', '1' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_MultipleBytes() {
        byte[] input = { (byte) 0x01, (byte) 0x02 };
        byte[] expected = new byte[] { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_CheckBitValues() {
        byte[] input = { (byte) 0xFF };
        byte[] expected = new byte[] { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_CheckBitValuesZero() {
        byte[] input = { (byte) 0x00 };
        byte[] expected = new byte[] { '0', '0', '0', '0', '0', '0', '0', '0' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }
}
// ```
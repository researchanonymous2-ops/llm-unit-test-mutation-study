package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecLlama_COC1Test {

    @Test
    public void testToAsciiBytes_NullInput() {
        byte[] input = null;
        byte[] expected = new byte[0];
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_EmptyInput() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_SingleByteInput() {
        byte[] input = { (byte) 0x01 };
        byte[] expected = new byte[] { '0', '0', '0', '0', '0', '0', '0', '1' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_MultipleBytesInput() {
        byte[] input = { (byte) 0x01, (byte) 0x02 };
        byte[] expected = new byte[] { '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToAsciiBytes_MaxByteInput() {
        byte[] input = { (byte) 0xFF };
        byte[] expected = new byte[] { '1', '1', '1', '1', '1', '1', '1', '1' };
        byte[] actual = BinaryCodec.toAsciiBytes(input);
        assertArrayEquals(expected, actual);
    }
}
// ```
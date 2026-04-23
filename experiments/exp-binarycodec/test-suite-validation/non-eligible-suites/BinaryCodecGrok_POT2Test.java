package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryCodecGrok_POT2Test {

    @Test
    public void testToAsciiBytes_NullOrEmpty() {
        BinaryCodec codec = new BinaryCodec();
        assertArrayEquals(new byte[0], codec.toAsciiBytes(null));
        assertArrayEquals(new byte[0], codec.toAsciiBytes(new byte[0]));
    }

    @Test
    public void testToAsciiBytes_SingleByte() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = new byte[]{(byte) 0};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0'};
        byte[] result = codec.toAsciiBytes(input);
        assertEquals(8, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_SingleByteAllOnes() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = new byte[]{(byte) 255};
        byte[] expected = new byte[]{'1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = codec.toAsciiBytes(input);
        assertEquals(8, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_MultipleBytes() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = new byte[]{(byte) 0, (byte) 255};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] result = codec.toAsciiBytes(input);
        assertEquals(16, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToAsciiBytes_MixedBytes() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = new byte[]{(byte) 1, (byte) 2};
        byte[] expected = new byte[]{'0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0'};
        byte[] result = codec.toAsciiBytes(input);
        assertEquals(16, result.length);
        assertArrayEquals(expected, result);
    }
}
// ```
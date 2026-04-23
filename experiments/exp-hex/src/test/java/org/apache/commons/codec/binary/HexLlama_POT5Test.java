package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexLlama_POT5Test {

    @Test
    public void testEncodeHex_ArrayVazio() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        char[] actual = Hex.encodeHex(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeHex_UmByte() {
        byte[] input = {0x12};
        char[] expected = {'1', '2'};
        char[] actual = Hex.encodeHex(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeHex_MultiplosBytes() {
        byte[] input = {0x12, 0x34, (byte) 0xAB, (byte) 0xCD};
        char[] expected = {'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        char[] actual = Hex.encodeHex(input);
        assertArrayEquals(expected, actual);
        assertEquals(2 * input.length, actual.length);
    }
}
// ```
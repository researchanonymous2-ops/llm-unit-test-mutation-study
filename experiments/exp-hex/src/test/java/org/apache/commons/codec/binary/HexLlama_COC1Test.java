package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HexLlama_COC1Test {

    @Test
    public void testEncodeHex_NullInput() {
        assertThrows(NullPointerException.class, () -> Hex.encodeHex(null));
    }

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] input = new byte[]{};
        char[] expected = new char[]{};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleElement() {
        byte[] input = new byte[]{0x12};
        char[] expected = new char[]{'1', '2'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_MultipleElements() {
        byte[] input = new byte[]{0x12, 0x34, (byte) 0xAB, (byte) 0xCD};
        char[] expected = new char[]{'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_Zero() {
        byte[] input = new byte[]{0x00};
        char[] expected = new char[]{'0', '0'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_MaxByte() {
        byte[] input = new byte[]{(byte) 0xFF};
        char[] expected = new char[]{'f', 'f'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }
}
// ```
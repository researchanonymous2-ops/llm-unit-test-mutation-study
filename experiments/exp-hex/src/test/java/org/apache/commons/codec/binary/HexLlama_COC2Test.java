package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexLlama_COC2Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] input = new byte[]{};
        char[] expected = new char[]{};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_SingleByte() {
        byte[] input = new byte[]{0x12};
        char[] expected = new char[]{'1', '2'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] input = new byte[]{0x12, 0x34, (byte) 0xAB, (byte) 0xCD};
        char[] expected = new char[]{'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        assertArrayEquals(expected, Hex.encodeHex(input));
    }

    @Test
    public void testEncodeHex_NullInput() {
        try {
            Hex.encodeHex(null);
            assert false : "Expected NullPointerException";
        } catch (NullPointerException e) {
            // expected
        }
    }
}
// ```
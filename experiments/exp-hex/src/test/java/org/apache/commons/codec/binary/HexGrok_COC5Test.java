package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexGrok_COC5Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_SingleByte() {
        byte[] input = new byte[]{0x00};
        char[] expected = new char[]{'0', '0'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] input = new byte[]{0x00, 0x01};
        char[] expected = new char[]{'0', '0', '0', '1'};
        char[] result = Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }
}
// ```
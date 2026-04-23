package org.apache.commons.codec.binary;

// ```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class HexGrok_COC4Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] input = new byte[0];
        char[] expected = new char[0];
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_SingleByte() {
        byte[] input = new byte[]{0};
        char[] expected = new char[]{'0', '0'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] input = new byte[]{1, 2};
        char[] expected = new char[]{'0', '1', '0', '2'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(input);
        assertArrayEquals(expected, result);
    }
}
// ```
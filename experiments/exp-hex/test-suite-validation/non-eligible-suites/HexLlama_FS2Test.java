package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HexLlama_FS2Test {

    @org.junit.Test
    public void testEncodeHex() {
        char[] data = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] expected = new char[]{'3', '0', '3', '1', '3', '2', '3', '3', '3', '4', '3', '5', '3', '6', '3', '7', '3', '8', '3', '9', '3', 'A', '3', 'B', '3', 'C', '3', 'D', '3', 'E', '3', 'F'};
        char[] result = org.apache.commons.codec.binary.Hex.encodeHex(data);
        assertArrayEquals(expected, result);
    }
}

public class HexLlama_FS2Test {
    @Test
    public void testEncodeHex() {
        byte[] data = new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};
        char[] expected = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F'};
        char[] result = Hex.encodeHex(data);
        assertArrayEquals(expected, result);
    }
}
// ```
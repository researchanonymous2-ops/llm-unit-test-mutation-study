package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexLlama_ZS4Test {

    @Test
    public void testEncodeHex_Null() {
        assertThrows(NullPointerException.class, () -> Hex.encodeHex(null));
    }

    @Test
    public void testEncodeHex_EmptyArray() {
        char[] result = Hex.encodeHex(new byte[]{});
        assertEquals(0, result.length);
    }

    @Test
    public void testEncodeHex_SingleByte() {
        char[] result = Hex.encodeHex(new byte[]{0x12});
        assertArrayEquals(new char[]{'1', '2'}, result);
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        char[] result = Hex.encodeHex(new byte[]{0x12, 0x34, (byte) 0xab, (byte) 0xcd});
        assertArrayEquals(new char[]{'1', '2', '3', '4', 'a', 'b', 'c', 'd'}, result);
    }

    @Test
    public void testEncodeHex_MinAndMaxByteValues() {
        char[] result = Hex.encodeHex(new byte[]{Byte.MIN_VALUE, Byte.MAX_VALUE});
        assertArrayEquals(new char[]{'8', '0', '7', 'f'}, result);
    }

    @Test
    public void testEncodeHex_AllPossibleByteValues() {
        byte[] data = new byte[256];
        for (int i = 0; i < 256; i++) {
            data[i] = (byte) i;
        }
        char[] result = Hex.encodeHex(data);
        assertEquals(512, result.length);
        for (int i = 0; i < 256; i++) {
            int index = i * 2;
            assertEquals(String.format("%02x", data[i]), new String(new char[]{result[index], result[index + 1]}));
        }
    }
}
// ```
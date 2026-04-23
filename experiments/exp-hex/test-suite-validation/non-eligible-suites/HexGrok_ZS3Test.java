package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexGrok_ZS3Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        byte[] data = new byte[0];
        char[] expected = new char[0];
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteZero() {
        byte[] data = new byte[]{0};
        char[] expected = new char[]{'0', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteOne() {
        byte[] data = new byte[]{1};
        char[] expected = new char[]{'0', '1'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteFifteen() {
        byte[] data = new byte[]{15};
        char[] expected = new char[]{'0', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteSixteen() {
        byte[] data = new byte[]{16};
        char[] expected = new char[]{'1', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteMaxPositive() {
        byte[] data = new byte[]{127};
        char[] expected = new char[]{'7', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteNegativeOne() {
        byte[] data = new byte[]{-1};
        char[] expected = new char[]{'f', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_SingleByteMinNegative() {
        byte[] data = new byte[]{-128};
        char[] expected = new char[]{'8', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        byte[] data = new byte[]{0, 1, 15, 16, -1};
        char[] expected = new char[]{'0', '0', '0', '1', '0', 'f', '1', '0', 'f', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_AllZeros() {
        byte[] data = new byte[]{0, 0, 0};
        char[] expected = new char[]{'0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }

    @Test
    public void testEncodeHex_MixedValues() {
        byte[] data = new byte[]{-128, 127, 0, 255};
        char[] expected = new char[]{'8', '0', '7', 'f', '0', '0', 'f', 'f'};
        assertArrayEquals(expected, org.apache.commons.codec.binary.Hex.encodeHex(data));
    }
}
// ```
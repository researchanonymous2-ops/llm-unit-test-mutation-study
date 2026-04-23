package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_POT4Test {

    @Test
    public void testEncodeHex_EmptyArray() {
        // Arrange
        byte[] data = new byte[0];
        // Act
        char[] result = Hex.encodeHex(data);
        // Assert
        assertEquals(0, result.length);
    }

    @Test
    public void testEncodeHex_SingleByte() {
        // Arrange
        byte[] data = {0x0F};
        // Act
        char[] result = Hex.encodeHex(data);
        // Assert
        assertEquals(2, result.length);
        assertEquals('0', result[0]);
        assertEquals('f', result[1]);
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        // Arrange
        byte[] data = {0x0F, 0xFF};
        // Act
        char[] result = Hex.encodeHex(data);
        // Assert
        assertEquals(4, result.length);
        assertEquals('0', result[0]);
        assertEquals('f', result[1]);
        assertEquals('f', result[2]);
        assertEquals('f', result[3]);
    }
}
// ```
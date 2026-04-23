package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.binary.Hex;

public class HexGrok_POT5Test {

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
    }

    @Test
    public void testEncodeHex_MultipleBytes() {
        // Arrange
        byte[] data = {0x0F, 0xFF};
        // Act
        char[] result = Hex.encodeHex(data);
        // Assert
        assertEquals(4, result.length);
    }
}
// ```
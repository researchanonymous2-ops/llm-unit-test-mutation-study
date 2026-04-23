package org.apache.commons.codec.binary;

// ```java
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexLlama_ZS3Test {

    @Test
    public void testEncodeHex() throws EncoderException {
        Hex hex = new Hex();
        byte[] bytes = {0x12, 0x34, 0x56, 0x78};
        char[] expected = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] actual = hex.encodeHex(bytes);
        assertArrayEquals(expected, actual);
    }
}
// ```
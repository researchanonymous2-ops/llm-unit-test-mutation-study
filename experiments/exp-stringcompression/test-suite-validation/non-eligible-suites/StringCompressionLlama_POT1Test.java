package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionLlama_POT1Test {

    @Test
    public void testCompress_SingleCharacter() {
        String input = "a";
        String expected = "a";
        String result = StringCompression.compress(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCompress_RepeatedCharacters() {
        String input = "aaabbbccc";
        String expected = "a3b3c3";
        String result = StringCompression.compress(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCompress_AlternatingCharacters() {
        String input = "ababab";
        String expected = "a1b1a1b1a1b1";
        String result = StringCompression.compress(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCompress_LastCharacterOutsideRepetition() {
        String input = "aaabbc";
        String expected = "a3b2c1";
        String result = StringCompression.compress(input);
        assertEquals(expected, result);
    }
}
// ```
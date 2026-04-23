package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionLlama_POT4Test {

    @Test
    public void testCompress_SingleCharacter() {
        String input = "a";
        String expected = "a";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_RepeatedCharacters() {
        String input = "aaabbbccc";
        String expected = "a3b3c3";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_AlternatingCharacters() {
        String input = "ababab";
        String expected = "a1b1a1b1a1b1";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_LastCharacterNotRepeated() {
        String input = "aaabccd";
        String expected = "a3b1c2d1";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }
}
// ```
package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionLlama_ZS4Test {

    @Test
    public void testCompress_SingleCharacter() {
        String input = "a";
        String expected = "a";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_NoCompression() {
        String input = "abcd";
        String expected = "a1b1c1d";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithCompression() {
        String input = "aaabbbccc";
        String expected = "a3b3c3";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_MixedCharacters() {
        String input = "aabcccccaaa";
        String expected = "a2b1c5a3";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_EmptyString() {
        String input = "";
        String expected = "";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_SingleCharacterRepeated() {
        String input = "aaaa";
        String expected = "a4";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_TwoDifferentCharacters() {
        String input = "ab";
        String expected = "a1b";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_TwoSameCharacters() {
        String input = "aa";
        String expected = "a2";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }
}
// ```
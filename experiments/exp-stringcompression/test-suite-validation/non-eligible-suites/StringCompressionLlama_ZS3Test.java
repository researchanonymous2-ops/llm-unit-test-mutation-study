package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionLlama_ZS3Test {

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
        String expected = "a1b1c1d1";
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
    public void testCompress_SameCharacters() {
        String input = "aaaaaaaaaa";
        String expected = "a10";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_TwoCharacters() {
        String input = "ab";
        String expected = "a1b1";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }
}
// ```
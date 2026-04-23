package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionLlama_ZS1Test {

    @Test
    public void testCompress_SingleCharacter() {
        String input = "a";
        String expected = "a";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_NoRepeatedCharacters() {
        String input = "abcd";
        String expected = "abcd";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithRepeatedCharacters() {
        String input = "aaabbbccc";
        String expected = "a3b3c3";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithSingleRepeatedCharacter() {
        String input = "aaa";
        String expected = "a3";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithTrailingSingleCharacter() {
        String input = "aaab";
        String expected = "a3b";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithTwoCharacters() {
        String input = "ab";
        String expected = "ab";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_WithTwoRepeatedCharacters() {
        String input = "aabb";
        String expected = "a2b2";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }
}
// ```
package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionLlama_COC5Test {

    @Test
    public void testCompress_SingleCharacter() {
        String input = "a";
        String expected = "a";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_TwoDifferentCharacters() {
        String input = "ab";
        String expected = "ab";
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

    @Test
    public void testCompress_MultipleDifferentCharacters() {
        String input = "abc";
        String expected = "abc";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_MultipleSameCharacters() {
        String input = "aaaa";
        String expected = "a4";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_MixedCharacters() {
        String input = "aabbbcc";
        String expected = "a2b3c2";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_LastTwoCharactersDifferent() {
        String input = "aabccd";
        String expected = "a2b1c2d";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompress_LastCharacterDifferent() {
        String input = "aaaab";
        String expected = "a4b";
        String actual = StringCompression.compress(input);
        assertEquals(expected, actual);
    }
}
// ```
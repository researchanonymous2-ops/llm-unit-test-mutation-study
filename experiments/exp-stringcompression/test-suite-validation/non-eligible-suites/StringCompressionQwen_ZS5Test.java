package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_ZS5Test {

    @Test
    public void testCompress_singleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_twoSameCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_twoDifferentCharacters() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_threeSameCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_mixedCharactersNoRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_repeatedAndNonRepeatedMix() {
        assertEquals("a2bc3d", StringCompression.compress("aabcccdd"));
    }

    @Test
    public void testCompress_longRepetitionAtEnd() {
        assertEquals("ab2c4", StringCompression.compress("abbcccc"));
    }

    @Test
    public void testCompress_emptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testCompress_complexRepetitionPattern() {
        assertEquals("a3b2c1d4", StringCompression.compress("aaabbcdddd"));
    }

    @Test
    public void testCompress_allSameCharacters() {
        assertEquals("a5", StringCompression.compress("aaaaa"));
    }
}
// ```
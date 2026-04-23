package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_ZS4Test {

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
    public void testCompress_multipleSameCharacters() {
        assertEquals("a4", StringCompression.compress("aaaa"));
    }

    @Test
    public void testCompress_mixedCharacters() {
        assertEquals("a3b2c1", StringCompression.compress("aaabbc"));
    }

    @Test
    public void testCompress_noRepetition() {
        assertEquals("abcd", StringCompression.compress("abcd"));
    }

    @Test
    public void testCompress_emptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testCompress_complexCase() {
        assertEquals("a1b2c3d1e5", StringCompression.compress("abbcccdeeeee"));
    }

    @Test
    public void testCompress_singleRepeatingAtEnd() {
        assertEquals("a1b3", StringCompression.compress("abbb"));
    }

    @Test
    public void testCompress_allSameCharacters() {
        assertEquals("a5", StringCompression.compress("aaaaa"));
    }
}
// ```
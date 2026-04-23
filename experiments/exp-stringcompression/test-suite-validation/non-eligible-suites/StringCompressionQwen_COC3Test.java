package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_COC3Test {

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
        assertEquals("a1b", StringCompression.compress("ab"));
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
    public void testCompress_complexCase() {
        assertEquals("a1b2c3d1", StringCompression.compress("abbcccdd"));
    }

    @Test
    public void testCompress_allSameCharacters() {
        assertEquals("a6", StringCompression.compress("aaaaaa"));
    }

    @Test
    public void testCompress_alternatingCharacters() {
        assertEquals("a1b1a1b", StringCompression.compress("abab"));
    }
}
// ```
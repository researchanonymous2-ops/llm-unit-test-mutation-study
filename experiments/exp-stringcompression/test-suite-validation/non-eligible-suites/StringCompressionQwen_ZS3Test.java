package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_ZS3Test {

    @Test
    public void testCompress_singleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_noRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_allSameCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_mixedRepetition() {
        assertEquals("a2b2c3d", StringCompression.compress("aabbcccd"));
    }

    @Test
    public void testCompress_repetitionAtEnd() {
        assertEquals("ab2", StringCompression.compress("abb"));
    }

    @Test
    public void testCompress_repetitionAtStart() {
        assertEquals("a2bc", StringCompression.compress("aabc"));
    }

    @Test
    public void testCompress_emptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testCompress_twoCharactersNoRepetition() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_twoCharactersWithRepetition() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_complexRepetition() {
        assertEquals("a3b1c2d4e1f", StringCompression.compress("aaabccddddeef"));
    }
}
// ```
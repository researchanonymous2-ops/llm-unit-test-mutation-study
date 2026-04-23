package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_ZS2Test {

    @Test
    public void testCompress_singleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_emptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testCompress_noRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_allSameCharacters() {
        assertEquals("a4", StringCompression.compress("aaaa"));
    }

    @Test
    public void testCompress_mixedRepetition() {
        assertEquals("a3b2c1d1", StringCompression.compress("aaabbc1d"));
    }

    @Test
    public void testCompress_repetitionAtEnd() {
        assertEquals("a1b3", StringCompression.compress("abbb"));
    }

    @Test
    public void testCompress_repetitionAtStart() {
        assertEquals("a3b1c1", StringCompression.compress("aaabc"));
    }

    @Test
    public void testCompress_alternatingPattern() {
        assertEquals("a1b1a1b1", StringCompression.compress("abab"));
    }

    @Test
    public void testCompress_twoCharactersNoRepetition() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_twoCharactersWithRepetition() {
        assertEquals("a2", StringCompression.compress("aa"));
    }
}
// ```
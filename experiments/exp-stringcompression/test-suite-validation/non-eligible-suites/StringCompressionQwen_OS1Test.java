package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionQwen_OS1Test {

    @Test
    void testCompress_singleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_twoSameCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    void testCompress_multipleSameCharacters() {
        assertEquals("a5", StringCompression.compress("aaaaa"));
    }

    @Test
    void testCompress_mixedCharactersNoRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    void testCompress_repeatedAndNonRepeatedMix() {
        assertEquals("a2bc3d", StringCompression.compress("aabcccdd"));
    }

    @Test
    void testCompress_complexRepetition() {
        assertEquals("a3b2c4d1e2", StringCompression.compress("aaabbccccdeee"));
    }

    @Test
    void testCompress_allSameCharacters() {
        assertEquals("z8", StringCompression.compress("zzzzzzzz"));
    }

    @Test
    void testCompress_alternatingCharacters() {
        assertEquals("ababab", StringCompression.compress("ababab"));
    }

    @Test
    void testCompress_emptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    void testCompress_longRepetition() {
        assertEquals("x10", StringCompression.compress("xxxxxxxxxx"));
    }
}
// ```
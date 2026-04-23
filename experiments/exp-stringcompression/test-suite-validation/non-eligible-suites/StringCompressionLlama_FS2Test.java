package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionLlama_FS2Test {

    @Test
    void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_RepeatingCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    void testCompress_MixedCharacters() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    void testCompress_NoRepeatingCharacters() {
        assertEquals("abcd", StringCompression.compress("abcd"));
    }

    @Test
    void testCompress_RepeatingCharactersAtEnd() {
        assertEquals("a2b3", StringCompression.compress("aabbb"));
    }

    @Test
    void testCompress_RepeatingCharactersAtStart() {
        assertEquals("a3b", StringCompression.compress("aaab"));
    }

    @Test
    void testCompress_LongSequence() {
        assertEquals("a10", StringCompression.compress("aaaaaaaaaa"));
    }

    @Test
    void testCompress_SingleRepeatingCharacter() {
        assertEquals("a1", StringCompression.compress("a"));
    }

    @Test
    void testCompress_TwoDifferentCharacters() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    void testCompress_TwoRepeatingCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }
}
// ```
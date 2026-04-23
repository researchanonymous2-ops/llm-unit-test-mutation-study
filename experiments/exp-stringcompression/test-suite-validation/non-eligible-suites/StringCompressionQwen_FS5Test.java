package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionQwen_FS5Test {

    @Test
    void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_TwoSameCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    void testCompress_ThreeSameCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    void testCompress_MultipleGroups() {
        assertEquals("a3b2c", StringCompression.compress("aaabbc"));
    }

    @Test
    void testCompress_NoRepetition() {
        assertEquals("abcd", StringCompression.compress("abcd"));
    }

    @Test
    void testCompress_MixedRepetitions() {
        assertEquals("a2b3c2d", StringCompression.compress("aabbbcccd"));
    }

    @Test
    void testCompress_SingleAtEnd() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    void testCompress_LongRepetition() {
        assertEquals("x10", StringCompression.compress("xxxxxxxxxx"));
    }

    @Test
    void testCompress_AlternatingPattern() {
        assertEquals("a1b1a1b", StringCompression.compress("abab"));
    }
}
// ```
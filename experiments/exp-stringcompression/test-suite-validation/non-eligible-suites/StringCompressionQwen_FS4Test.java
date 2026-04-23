package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionQwen_FS4Test {

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
    void testCompress_NoRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    void testCompress_MixedRepetition() {
        assertEquals("a2bc3d", StringCompression.compress("aabcccdd"));
    }

    @Test
    void testCompress_AllSameCharacters() {
        assertEquals("a5", StringCompression.compress("aaaaa"));
    }

    @Test
    void testCompress_EndingWithRepetition() {
        assertEquals("ab2c3", StringCompression.compress("abbccc"));
    }

    @Test
    void testCompress_StartsWithRepetition() {
        assertEquals("a3bc", StringCompression.compress("aaabc"));
    }

    @Test
    void testCompress_SingleCharacterAtEnd() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }
}
// ```
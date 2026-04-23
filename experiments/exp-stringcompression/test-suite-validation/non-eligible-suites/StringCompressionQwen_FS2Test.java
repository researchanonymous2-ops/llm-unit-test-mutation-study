package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionQwen_FS2Test {

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
        assertEquals("a2b2c2", StringCompression.compress("aabbcc"));
    }

    @Test
    void testCompress_SingleAndRepeated() {
        assertEquals("ab2c", StringCompression.compress("abbc"));
    }

    @Test
    void testCompress_MixedSingleAndMultiple() {
        assertEquals("a2bc2d", StringCompression.compress("aabcccd"));
    }

    @Test
    void testCompress_AllSameCharacters() {
        assertEquals("a5", StringCompression.compress("aaaaa"));
    }

    @Test
    void testCompress_NoRepetition() {
        assertEquals("abcd", StringCompression.compress("abcd"));
    }

    @Test
    void testCompress_EndingWithSingle() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }
}
// ```
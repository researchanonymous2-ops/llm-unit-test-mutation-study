package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_FS3Test {

    @Test
    void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_AllSameCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    void testCompress_NoRepeats() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    void testCompress_MixedRepeats() {
        assertEquals("a2b2c", StringCompression.compress("aabbc"));
    }

    @Test
    void testCompress_SingleRepeatAtEnd() {
        assertEquals("a3b", StringCompression.compress("aaab"));
    }

    @Test
    void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    void testCompress_WithNumbers() {
        assertEquals("1a2b", StringCompression.compress("1aab"));
    }

    @Test
    void testCompress_AllDifferent() {
        assertEquals("abcd", StringCompression.compress("abcd"));
    }

    @Test
    void testCompress_LongRepeat() {
        assertEquals("z5", StringCompression.compress("zzzzz"));
    }

    @Test
    void testCompress_SingleAfterRepeat() {
        assertEquals("a2bc", StringCompression.compress("aabc"));
    }
}
// ```
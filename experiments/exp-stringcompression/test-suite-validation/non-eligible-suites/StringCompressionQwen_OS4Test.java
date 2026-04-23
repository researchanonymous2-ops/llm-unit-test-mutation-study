package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionQwen_OS4Test {

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
        assertEquals("a3b2c1d4", StringCompression.compress("aaabbccdddd"));
    }

    @Test
    void testCompress_NoRepetition() {
        assertEquals("abcd", StringCompression.compress("abcd"));
    }

    @Test
    void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    void testCompress_SingleCharacterRepeatedManyTimes() {
        assertEquals("z5", StringCompression.compress("zzzzz"));
    }

    @Test
    void testCompress_ComplexPattern() {
        assertEquals("a1b2c3d1e1f2", StringCompression.compress("abbcccdeeff"));
    }

    @Test
    void testCompress_AllSameCharacters() {
        assertEquals("x7", StringCompression.compress("xxxxxxx"));
    }

    @Test
    void testCompress_AlternatingCharacters() {
        assertEquals("a1b1a1b1", StringCompression.compress("abab"));
    }
}
// ```
package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionQwen_OS5Test {

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
    void testCompress_MixedCharactersNoRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    void testCompress_MixedRepetitions() {
        assertEquals("a2b2c2", StringCompression.compress("aabbcc"));
    }

    @Test
    void testCompress_SingleAndRepeated() {
        assertEquals("ab2c", StringCompression.compress("abbc"));
    }

    @Test
    void testCompress_EndingWithSingleCharacter() {
        assertEquals("a3bc", StringCompression.compress("aaabc"));
    }

    @Test
    void testCompress_LongRepetition() {
        assertEquals("a10", StringCompression.compress("aaaaaaaaaa"));
    }

    @Test
    void testCompress_ComplexPattern() {
        assertEquals("a3b1c4d2", StringCompression.compress("aaabccccdd"));
    }

    @Test
    void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }
}
// ```
package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_COC5Test {

    @Test
    public void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_TwoSameCharacters() {
        assertEquals("aa", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_TwoDifferentCharacters() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_RepeatedAtEnd() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    public void testCompress_NoRepeats() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_MultipleRepeats() {
        assertEquals("a2b2c", StringCompression.compress("aabbcc"));
    }

    @Test
    public void testCompress_SingleRepeatInMiddle() {
        assertEquals("ab2c", StringCompression.compress("abbc"));
    }

    @Test
    public void testCompress_RepeatAtStart() {
        assertEquals("a2bc", StringCompression.compress("aabc"));
    }

    @Test
    public void testCompress_AllSame() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_Complex() {
        assertEquals("a2b3c2", StringCompression.compress("aabbbcc"));
    }
}
// ```
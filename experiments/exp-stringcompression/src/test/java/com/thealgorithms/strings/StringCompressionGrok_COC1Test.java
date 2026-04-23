package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_COC1Test {

    @Test
    public void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_TwoSameCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_TwoDifferentCharacters() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_ThreeCharactersWithRepeat() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    public void testCompress_ThreeCharactersWithRepeatAtEnd() {
        assertEquals("ab2", StringCompression.compress("abb"));
    }

    @Test
    public void testCompress_NoRepeats() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_AllSame() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_Mixed() {
        assertEquals("a3b2c", StringCompression.compress("aaabbc"));
    }
}
// ```
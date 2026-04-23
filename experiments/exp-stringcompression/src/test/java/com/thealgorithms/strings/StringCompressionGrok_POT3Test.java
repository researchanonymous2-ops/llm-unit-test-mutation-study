package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionGrok_POT3Test {

    @Test
    void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_RepeatedCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    void testCompress_AlternatingCharacters() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    void testCompress_LastCharacterDifferent() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }
}
// ```
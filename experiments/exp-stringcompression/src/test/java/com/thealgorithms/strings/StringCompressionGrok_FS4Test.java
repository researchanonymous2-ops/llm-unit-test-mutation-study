package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_FS4Test {

    @Test
    void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_TwoIdenticalCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    void testCompress_TwoDifferentCharacters() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    void testCompress_ThreeIdenticalCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    void testCompress_MixedGroups() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    void testCompress_AllDifferent() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    void testCompress_GroupAtEnd() {
        assertEquals("a3b", StringCompression.compress("aaab"));
    }

    @Test
    void testCompress_MultipleGroups() {
        assertEquals("a2b2", StringCompression.compress("aabb"));
    }

    @Test
    void testCompress_SingleGroupLonger() {
        assertEquals("a4", StringCompression.compress("aaaa"));
    }

    @Test
    void testCompress_WithNumbers() {
        assertEquals("1a2", StringCompression.compress("1aa"));
    }
}
// ```
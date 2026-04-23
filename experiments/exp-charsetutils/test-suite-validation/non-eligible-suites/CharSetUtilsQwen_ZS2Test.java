package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_ZS2Test {

    @Test
    public void testSqueeze_nullString() {
        assertNull(org.apache.commons.lang3.CharSetUtils.squeeze(null, "a-z"));
    }

    @Test
    public void testSqueeze_emptyString() {
        assertEquals("", org.apache.commons.lang3.CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_nullSet() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_emptySetArray() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello"));
    }

    @Test
    public void testSqueeze_emptySetString() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_singleCharacterRepetition() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    public void testSqueeze_multipleCharactersRepetition() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("helllo", "l"));
    }

    @Test
    public void testSqueeze_rangeSet() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_noMatch() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "0-9"));
    }

    @Test
    public void testSqueeze_mixedCharacters() {
        assertEquals("he2o", org.apache.commons.lang3.CharSetUtils.squeeze("hee22o", "e2"));
    }

    @Test
    public void testSqueeze_specialCharacters() {
        assertEquals("a,b,c", org.apache.commons.lang3.CharSetUtils.squeeze("a,,,b,,,,c", ","));
    }

    @Test
    public void testSqueeze_unicodeCharacters() {
        assertEquals("café", org.apache.commons.lang3.CharSetUtils.squeeze("caaafé", "a"));
    }

    @Test
    public void testSqueeze_adjacentDifferentChars() {
        assertEquals("abab", org.apache.commons.lang3.CharSetUtils.squeeze("aababb", "a"));
    }

    @Test
    public void testSqueeze_allSameChar() {
        assertEquals("a", org.apache.commons.lang3.CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_caseSensitive() {
        assertEquals("Aa", org.apache.commons.lang3.CharSetUtils.squeeze("AAaa", "A"));
    }
}
// ```
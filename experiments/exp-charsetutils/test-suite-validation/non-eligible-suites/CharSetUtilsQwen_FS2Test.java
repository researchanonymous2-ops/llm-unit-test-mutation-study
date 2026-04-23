package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_FS2Test {

    @Test
    void testSqueeze_nullString() {
        assertNull(CharSetUtils.squeeze(null, "a-z"));
    }

    @Test
    void testSqueeze_emptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    void testSqueeze_nullSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    void testSqueeze_emptySetArray() {
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }

    @Test
    void testSqueeze_emptyStringInSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    void testSqueeze_noRepeatsInInput() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
    }

    @Test
    void testSqueeze_allRepeatsRemoved() {
        assertEquals("ababa", CharSetUtils.squeeze("aaaabbbbaaaaabbbb", "b"));
    }

    @Test
    void testSqueeze_multipleRanges() {
        assertEquals("helo wrd", CharSetUtils.squeeze("hello world", "l", "o"));
    }

    @Test
    void testSqueeze_unicodeCharacters() {
        assertEquals("café", CharSetUtils.squeeze("caaafééé", "a", "é"));
    }

    @Test
    void testSqueeze_firstCharacterRepeat() {
        assertEquals("banana", CharSetUtils.squeeze("bbbanana", "b"));
    }

    @Test
    void testSqueeze_specialCharacters() {
        assertEquals("a*b*c", CharSetUtils.squeeze("a***b***c", "*"));
    }

    @Test
    void testSqueeze_noMatchInSet() {
        assertEquals("test", CharSetUtils.squeeze("test", "x-z"));
    }

    @Test
    void testSqueeze_mixedCase() {
        assertEquals("AaBbCc", CharSetUtils.squeeze("AaaBbbCcc", "a", "b", "c"));
    }

    @Test
    void testSqueeze_numericCharacters() {
        assertEquals("123a45b6", CharSetUtils.squeeze("11233a4455b66", "1", "3", "4"));
    }
}
// ```
package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_FS1Test {

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
    void testSqueeze_noMatchingCharacters() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "d-f"));
    }

    @Test
    void testSqueeze_allMatchingCharactersRepeated() {
        assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    void testSqueeze_mixedRepeatedMatchingAndNonMatching() {
        assertEquals("abcbab", CharSetUtils.squeeze("aabbcbab", "b"));
    }

    @Test
    void testSqueeze_multipleRangesInSet() {
        assertEquals("helo world", CharSetUtils.squeeze("hello world", "a-c", "l-o"));
    }

    @Test
    void testSqueeze_unicodeCharacters() {
        assertEquals("héllo", CharSetUtils.squeeze("héllo", "a-z"));
    }

    @Test
    void testSqueeze_specialCharacters() {
        assertEquals("a*b*c", CharSetUtils.squeeze("a**b**c", "*"));
    }

    @Test
    void testSqueeze_consecutiveMatchingCharsAtStart() {
        assertEquals("abc", CharSetUtils.squeeze("aaabbbccc", "a-c"));
    }

    @Test
    void testSqueeze_consecutiveMatchingCharsAtEnd() {
        assertEquals("xyzabc", CharSetUtils.squeeze("xyzzaaabbbccc", "a-c"));
    }

    @Test
    void testSqueeze_singleCharacterString() {
        assertEquals("x", CharSetUtils.squeeze("x", "a-z"));
    }

    @Test
    void testSqueeze_repeatedSingleCharacter() {
        assertEquals("x", CharSetUtils.squeeze("xxxxx", "x"));
    }
}
// ```
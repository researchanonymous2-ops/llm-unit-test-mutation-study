package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_FS4Test {

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
    void testSqueeze_emptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }

    @Test
    void testSqueeze_singleCharacterRepeated() {
        assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    void testSqueeze_mixedRepeats() {
        assertEquals("abab", CharSetUtils.squeeze("aabbab", "b"));
    }

    @Test
    void testSqueeze_noMatchInSet() {
        assertEquals("abcabc", CharSetUtils.squeeze("abcabc", "d-f"));
    }

    @Test
    void testSqueeze_multipleSets() {
        assertEquals("helo world", CharSetUtils.squeeze("hello world", "o", "l"));
    }

    @Test
    void testSqueeze_specialCharacters() {
        assertEquals("a*b*c", CharSetUtils.squeeze("a**b**c", "*"));
    }

    @Test
    void testSqueeze_unicodeCharacters() {
        assertEquals("café", CharSetUtils.squeeze("caaafé", "a"));
    }
}
// ```
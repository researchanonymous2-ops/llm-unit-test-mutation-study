package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsLlama_FS5Test {

    @Test
    void testSqueeze_NullInput() {
        assertNull(CharSetUtils.squeeze(null, "a-z"));
    }

    @Test
    void testSqueeze_EmptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    void testSqueeze_NullSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    void testSqueeze_EmptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }

    @Test
    void testSqueeze_NoCharactersInSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    void testSqueeze_WithRepeatedCharactersInSet() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    void testSqueeze_MultipleSets() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l", "o"));
    }

    @Test
    void testSqueeze_RangeInSet() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    void testSqueeze_SingleCharacterString() {
        assertEquals("a", CharSetUtils.squeeze("a", "a"));
    }

    @Test
    void testSqueeze_SingleCharacterRepeated() {
        assertEquals("aa", CharSetUtils.squeeze("aaa", "b"));
    }
}
// ```
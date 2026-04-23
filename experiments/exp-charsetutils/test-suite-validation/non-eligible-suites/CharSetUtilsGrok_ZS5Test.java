package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_ZS5Test {

    @Test
    public void testSqueeze_NullInput() {
        assertNull(CharSetUtils.squeeze(null, "a"));
    }

    @Test
    public void testSqueeze_EmptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }

    @Test
    public void testSqueeze_NullSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_EmptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_Example1() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_Example2() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_NoRepetitions() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "a"));
    }

    @Test
    public void testSqueeze_RepetitionsNotInSet() {
        assertEquals("aabb", CharSetUtils.squeeze("aabb", "c"));
    }

    @Test
    public void testSqueeze_RepetitionsInSet() {
        assertEquals("ab", CharSetUtils.squeeze("aabb", "a"));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        assertEquals("ab", CharSetUtils.squeeze("aaabbb", "a", "b"));
    }

    @Test
    public void testSqueeze_NonConsecutiveRepetitions() {
        assertEquals("abab", CharSetUtils.squeeze("abab", "a"));
    }

    @Test
    public void testSqueeze_SingleCharacterRepetitions() {
        assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
    }

    @Test
    public void testSqueeze_RangeInSet() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l-o"));
    }

    @Test
    public void testSqueeze_AllCharactersInSet() {
        assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_NoCharactersInSet() {
        assertEquals("xyz", CharSetUtils.squeeze("xyz", "a"));
    }

    @Test
    public void testSqueeze_MixedCase() {
        assertEquals("Hllo", CharSetUtils.squeeze("Hello", "e"));
    }

    @Test
    public void testSqueeze_EmptySetArray() {
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }
}
// ```
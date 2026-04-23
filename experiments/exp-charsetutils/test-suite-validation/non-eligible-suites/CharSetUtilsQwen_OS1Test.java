package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsQwen_OS1Test {

    @Test
    void testSqueeze_NullString_ReturnsNull() {
        assertEquals(null, CharSetUtils.squeeze(null, "abc"));
    }

    @Test
    void testSqueeze_EmptyString_ReturnsEmpty() {
        assertEquals("", CharSetUtils.squeeze("", "abc"));
    }

    @Test
    void testSqueeze_NullSet_ReturnsOriginalString() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    void testSqueeze_EmptySet_ReturnsOriginalString() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    void testSqueeze_NoRepetitionsInSet_ReturnsOriginal() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "xyz"));
    }

    @Test
    void testSqueeze_RepeatedCharsInSet_Squeezed() {
        assertEquals("abca", CharSetUtils.squeeze("abccca", "c"));
    }

    @Test
    void testSqueeze_MultipleRepetitions_Squeezed() {
        assertEquals("abaca", CharSetUtils.squeeze("abccaacaa", "c"));
    }

    @Test
    void testSqueeze_CharacterRange_Squeezed() {
        assertEquals("abcdef", CharSetUtils.squeeze("aabbbccccdef", "a-c"));
    }

    @Test
    void testSqueeze_MultipleSets_Squeezed() {
        assertEquals("abcdef", CharSetUtils.squeeze("aabbccdef", "a-b", "c"));
    }

    @Test
    void testSqueeze_NoCharsMatch_ReturnsOriginal() {
        assertEquals("xyz", CharSetUtils.squeeze("xyz", "abc"));
    }

    @Test
    void testSqueeze_AllCharsMatch_Squeezed() {
        assertEquals("aba", CharSetUtils.squeeze("aaaaabbbbbaaaaa", "ab"));
    }

    @Test
    void testSqueeze_SingleCharString_ReturnsSame() {
        assertEquals("a", CharSetUtils.squeeze("a", "a"));
    }

    @Test
    void testSqueeze_TwoSameCharsInSet_Squeezed() {
        assertEquals("a", CharSetUtils.squeeze("aa", "a"));
    }

    @Test
    void testSqueeze_TwoDifferentCharsInSet_NotSqueezed() {
        assertEquals("ab", CharSetUtils.squeeze("ab", "ab"));
    }

    @Test
    void testSqueeze_MixedRepetitions_SomeSqueezed() {
        assertEquals("aabbccd", CharSetUtils.squeeze("aabbbcccd", "b"));
    }

    @Test
    void testSqueeze_EmptyResult() {
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }
}
// ```
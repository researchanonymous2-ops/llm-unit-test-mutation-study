package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_ZS4Test {

    @Test
    public void testSqueeze_NullString() {
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
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }

    @Test
    public void testSqueeze_EmptySetStrings() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "", ""));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_SqueezeExample() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_SingleCharRepeat() {
        assertEquals("ab", CharSetUtils.squeeze("aab", "a"));
    }

    @Test
    public void testSqueeze_MultipleCharsRepeat() {
        assertEquals("abc", CharSetUtils.squeeze("aabbcc", "a-c"));
    }

    @Test
    public void testSqueeze_NoRepeat() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
    }

    @Test
    public void testSqueeze_MixedRepeats() {
        assertEquals("abac", CharSetUtils.squeeze("aabbac", "a"));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-l", "m-p"));
    }

    @Test
    public void testSqueeze_SpecialChars() {
        assertEquals("a b", CharSetUtils.squeeze("a  b", " "));
    }

    @Test
    public void testSqueeze_AllRepeats() {
        assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
    }

    @Test
    public void testSqueeze_EmptyAfterSqueeze() {
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }
}
// ```
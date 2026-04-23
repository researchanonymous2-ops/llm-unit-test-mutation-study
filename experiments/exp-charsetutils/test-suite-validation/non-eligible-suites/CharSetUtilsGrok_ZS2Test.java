package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsGrok_ZS2Test {

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
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_SingleSet() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
    }

    @Test
    public void testSqueeze_NoRepetitions() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
    }

    @Test
    public void testSqueeze_RepetitionsNotInSet() {
        assertEquals("aabbcc", CharSetUtils.squeeze("aabbcc", "d-f"));
    }

    @Test
    public void testSqueeze_AllRepetitions() {
        assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
    }

    @Test
    public void testSqueeze_MixedCharacters() {
        assertEquals("a1b2c", CharSetUtils.squeeze("a11b22c", "1-2"));
    }

    @Test
    public void testSqueeze_SingleCharacter() {
        assertEquals("a", CharSetUtils.squeeze("aa", "a"));
    }

    @Test
    public void testSqueeze_EmptyStringWithSet() {
        assertEquals("", CharSetUtils.squeeze("", "a-b"));
    }
}
// ```
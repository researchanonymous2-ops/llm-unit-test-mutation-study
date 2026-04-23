package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsGrok_ZS3Test {

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
    public void testSqueeze_RemoveConsecutiveDuplicatesInSet() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_NoDuplicatesInSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_NoConsecutiveDuplicates() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
    }

    @Test
    public void testSqueeze_MultipleConsecutiveDuplicates() {
        assertEquals("ab", CharSetUtils.squeeze("aaabbb", "a-b"));
    }

    @Test
    public void testSqueeze_MixedCharacters() {
        assertEquals("a1b2c", CharSetUtils.squeeze("a11b22c", "1-2"));
    }

    @Test
    public void testSqueeze_SingleCharacterSet() {
        assertEquals("ab", CharSetUtils.squeeze("aab", "a"));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
    }

    @Test
    public void testSqueeze_AllCharactersInSet() {
        assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
    }

    @Test
    public void testSqueeze_NoCharactersInSet() {
        assertEquals("xyz", CharSetUtils.squeeze("xyz", "a-c"));
    }
}
// ```
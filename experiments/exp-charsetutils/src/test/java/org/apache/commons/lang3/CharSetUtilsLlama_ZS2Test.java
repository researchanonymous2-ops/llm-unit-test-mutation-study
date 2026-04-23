package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CharSetUtilsLlama_ZS2Test {

    @Test
    public void testSqueeze_NullString() {
        assertNull(CharSetUtils.squeeze(null, "a-e"));
    }

    @Test
    public void testSqueeze_EmptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a-e"));
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
    public void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_Squeeze() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p", "l"));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        assertEquals("helo", CharSetUtils.squeeze("helllllo", "l", "o"));
    }

    @Test
    public void testSqueeze_SingleCharacterString() {
        assertEquals("a", CharSetUtils.squeeze("aa", "a"));
    }

    @Test
    public void testSqueeze_SameCharacters() {
        assertEquals("a", CharSetUtils.squeeze("aaaaaa", "a"));
    }
}
// ```
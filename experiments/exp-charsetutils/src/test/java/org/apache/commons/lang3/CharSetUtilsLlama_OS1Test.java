package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsLlama_OS1Test {

    @Test
    void testSqueeze_NullString() {
        assertEquals(null, CharSetUtils.squeeze(null, "a-e"));
    }

    @Test
    void testSqueeze_EmptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a-e"));
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
    void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "x-z"));
    }

    @Test
    void testSqueeze_Squeeze() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    void testSqueeze_MultipleSets() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l", "l-m"));
    }

    @Test
    void testSqueeze_Range() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    void testSqueeze_NoChange() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }
}
// ```
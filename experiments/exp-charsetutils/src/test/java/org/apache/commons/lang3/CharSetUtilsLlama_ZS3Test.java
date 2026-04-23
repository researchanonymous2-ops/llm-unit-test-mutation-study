package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CharSetUtilsLlama_ZS3Test {

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
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "x-z"));
    }

    @Test
    public void testSqueeze_Squeeze() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l", "l-m"));
    }

    @Test
    public void testSqueeze_Range() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_NoChange() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }
}
// ```
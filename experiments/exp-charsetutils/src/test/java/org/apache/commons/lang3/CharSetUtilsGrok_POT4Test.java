package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_POT4Test {

    @Test
    public void testSqueeze_NullStr() {
        assertEquals(null, CharSetUtils.squeeze(null, "a"));
    }

    @Test
    public void testSqueeze_EmptyStr() {
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
    public void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_WithSqueeze() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }
}
// ```
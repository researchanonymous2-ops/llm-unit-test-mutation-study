package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CharSetUtilsLlama_POT4Test {

    @Test
    public void testSqueeze_NullString() {
        String str = null;
        String[] set = {"a-e"};
        assertNull(CharSetUtils.squeeze(str, set));
    }

    @Test
    public void testSqueeze_EmptyString() {
        String str = "";
        String[] set = {"a-e"};
        assertEquals("", CharSetUtils.squeeze(str, set));
    }

    @Test
    public void testSqueeze_NullSet() {
        String str = "hello";
        String[] set = null;
        assertEquals("hello", CharSetUtils.squeeze(str, set));
    }

    @Test
    public void testSqueeze_EmptySet() {
        String str = "hello";
        String[] set = {};
        assertEquals("hello", CharSetUtils.squeeze(str, set));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        String str = "hello";
        String[] set = {"a-e"};
        assertEquals("hello", CharSetUtils.squeeze(str, set));
    }

    @Test
    public void testSqueeze_WithSqueeze() {
        String str = "hello";
        String[] set = {"l-o"};
        assertEquals("helo", CharSetUtils.squeeze(str, set));
    }

    @Test
    public void testSqueeze_MultipleSets() {
        String str = "hello world";
        String[] set = {"l", "o"};
        assertEquals("helo world", CharSetUtils.squeeze(str, set));
    }
}
// ```
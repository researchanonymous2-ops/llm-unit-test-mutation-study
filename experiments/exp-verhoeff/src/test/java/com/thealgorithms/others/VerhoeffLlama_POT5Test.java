package com.thealgorithms.others;

// ```java
import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerhoeffLlama_POT5Test {

    @Test
    public void testVerhoeffCheck_ValidInput() {
        String input = "2363";
        assertTrue(Verhoeff.verhoeffCheck(input));
    }

    @Test
    public void testVerhoeffCheck_InvalidInput() {
        String input = "2364";
        assertFalse(Verhoeff.verhoeffCheck(input));
    }

    @Test
    public void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput() {
        String input = "123a";
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(input));
    }

    @Test
    public void testVerhoeffCheck_EmptyString() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(input));
    }
}
// ```
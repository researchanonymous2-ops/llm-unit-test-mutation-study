package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerhoeffLlama_POT4Test {

    @Test
    public void testVerhoeffCheck_ValidInput_ReturnsTrue() {
        String input = "2363";
        assertTrue(Verhoeff.verhoeffCheck(input));
    }

    @Test
    public void testVerhoeffCheck_InvalidInput_ReturnsFalse() {
        String input = "2364";
        assertFalse(Verhoeff.verhoeffCheck(input));
    }

    @Test
    public void testVerhoeffCheck_NullInput_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput_ThrowsIllegalArgumentException() {
        String input = "123a";
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(input));
    }

    @Test
    public void testVerhoeffCheck_EmptyString_ThrowsIllegalArgumentException() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(input));
    }
}
// ```
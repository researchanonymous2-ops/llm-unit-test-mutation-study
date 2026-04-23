package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerhoeffLlama_POT2Test {

    @Test
    public void testVerhoeffCheck_ValidInput() {
        String validInput = "2363";
        assertTrue(Verhoeff.verhoeffCheck(validInput));
    }

    @Test
    public void testVerhoeffCheck_InvalidInput() {
        String invalidInput = "2364";
        assertFalse(Verhoeff.verhoeffCheck(invalidInput));
    }

    @Test
    public void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput() {
        String nonDigitInput = "123a";
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(nonDigitInput));
    }

    @Test
    public void testVerhoeffCheck_EmptyString() {
        String emptyString = "";
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(emptyString));
    }
}
// ```
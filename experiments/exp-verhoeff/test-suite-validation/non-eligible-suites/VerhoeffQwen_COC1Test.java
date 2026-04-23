package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffQwen_COC1Test {

    @Test
    public void testVerhoeffCheck_validInput() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_invalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    public void testVerhoeffCheck_singleDigitValid() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    public void testVerhoeffCheck_singleDigitInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    public void testVerhoeffCheck_emptyString() {
        assertFalse(Verhoeff.verhoeffCheck(""));
    }

    @Test
    public void testVerhoeffCheck_longValidNumber() {
        assertTrue(Verhoeff.verhoeffCheck("1428570"));
    }

    @Test
    public void testVerhoeffCheck_longInvalidNumber() {
        assertFalse(Verhoeff.verhoeffCheck("1428571"));
    }

    @Test
    public void testVerhoeffCheck_nullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_nonDigitCharacters() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12a3"));
    }

    @Test
    public void testVerhoeffCheck_onlyNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
    }
}
// ```
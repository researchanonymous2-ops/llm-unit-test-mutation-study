package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffQwen_ZS4Test {

    @Test
    public void testVerhoeffCheck_validInput_returnsTrue() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_invalidInput_returnsFalse() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    public void testVerhoeffCheck_singleDigitValid_returnsTrue() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    public void testVerhoeffCheck_singleDigitInvalid_returnsFalse() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    public void testVerhoeffCheck_emptyString_returnsTrue() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    public void testVerhoeffCheck_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_nonDigitInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12a3"));
    }

    @Test
    public void testVerhoeffCheck_longValidInput_returnsTrue() {
        assertTrue(Verhoeff.verhoeffCheck("1234567890"));
    }

    @Test
    public void testVerhoeffCheck_longInvalidInput_returnsFalse() {
        assertFalse(Verhoeff.verhoeffCheck("1234567891"));
    }
}
// ```
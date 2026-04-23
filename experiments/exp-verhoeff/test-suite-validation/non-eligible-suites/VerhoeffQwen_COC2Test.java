package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffQwen_COC2Test {

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
    public void testVerhoeffCheck_longValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("12345678900987654321"));
    }

    @Test
    public void testVerhoeffCheck_longInvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("12345678900987654322"));
    }

    @Test
    public void testVerhoeffCheck_allZeros() {
        assertTrue(Verhoeff.verhoeffCheck("0000000000"));
    }

    @Test
    public void testVerhoeffCheck_nullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_emptyString() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    public void testVerhoeffCheck_nonNumericInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a45"));
    }

    @Test
    public void testVerhoeffCheck_negativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("-123"));
    }
}
// ```
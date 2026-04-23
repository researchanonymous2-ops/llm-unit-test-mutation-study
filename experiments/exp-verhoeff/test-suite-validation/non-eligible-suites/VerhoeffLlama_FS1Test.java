package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffLlama_FS1Test {

    @Test
    void testVerhoeffCheck_ValidNumber() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_InvalidNumber() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInputThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("23A3"));
    }

    @Test
    void testVerhoeffCheck_NullInputThrowsException() {
        assertThrows(NullPointerException.class,
            () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_EmptyStringInput() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_SingleDigitValidNumber() {
        assertTrue(Verhoeff.verhoeffCheck("5"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitInvalidNumber() {
        assertFalse(Verhoeff.verhoeffCheck("4"));
    }
}
// ```
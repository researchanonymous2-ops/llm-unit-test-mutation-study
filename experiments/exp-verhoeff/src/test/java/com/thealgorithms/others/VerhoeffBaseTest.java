package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class VerhoeffBaseTest {

    @Test
    void testVerhoeffCheckWithValidDigits() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheckWithInvalidDigits() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheckWithNonNumericInput() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("23A3"));
    }

    @Test
    void testVerhoeffCheckWithNullInput() {
        assertThrows(NullPointerException.class,
            () -> Verhoeff.verhoeffCheck(null));
    }
}


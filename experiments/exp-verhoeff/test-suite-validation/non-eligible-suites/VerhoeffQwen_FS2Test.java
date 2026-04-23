package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffQwen_FS2Test {

    @Test
    void testVerhoeffCheck_ValidInput1() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_ValidInput2() {
        assertTrue(Verhoeff.verhoeffCheck("1234554321"));
    }

    @Test
    void testVerhoeffCheck_ValidInput3() {
        assertTrue(Verhoeff.verhoeffCheck("9876543210"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput1() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput2() {
        assertFalse(Verhoeff.verhoeffCheck("1234554322"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput3() {
        assertFalse(Verhoeff.verhoeffCheck("9876543211"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitValid() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    void testVerhoeffCheck_TwoDigitValid() {
        assertTrue(Verhoeff.verhoeffCheck("14"));
    }

    @Test
    void testVerhoeffCheck_TwoDigitInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("15"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInputThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("23A3"));
    }

    @Test
    void testVerhoeffCheck_EmptyStringThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_NullInputThrowsException() {
        assertThrows(NullPointerException.class,
            () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_InputWithSpacesThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("12 34"));
    }

    @Test
    void testVerhoeffCheck_InputWithSpecialCharactersThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("123-456"));
    }
}
// ```
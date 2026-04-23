package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffQwen_FS3Test {

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
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    void testVerhoeffCheck_ValidInput4() {
        assertTrue(Verhoeff.verhoeffCheck("555550"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput1() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput2() {
        assertFalse(Verhoeff.verhoeffCheck("1234567890"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput3() {
        assertFalse(Verhoeff.verhoeffCheck("111111"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput4() {
        assertFalse(Verhoeff.verhoeffCheck("987654321"));
    }

    @Test
    void testVerhoeffCheck_EmptyString() {
        assertTrue(Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_SingleDigitZero() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitNonZero() {
        assertFalse(Verhoeff.verhoeffCheck("7"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInputThrowsException1() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("123A5"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInputThrowsException2() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("12 345"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInputThrowsException3() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("12-345"));
    }

    @Test
    void testVerhoeffCheck_NullInputThrowsException() {
        assertThrows(NullPointerException.class,
            () -> Verhoeff.verhoeffCheck(null));
    }
}
// ```
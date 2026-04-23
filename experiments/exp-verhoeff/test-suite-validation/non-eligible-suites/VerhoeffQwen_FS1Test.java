package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffQwen_FS1Test {

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
        assertTrue(Verhoeff.verhoeffCheck("55550"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput1() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput2() {
        assertFalse(Verhoeff.verhoeffCheck("1234554320"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput3() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput4() {
        assertFalse(Verhoeff.verhoeffCheck("55551"));
    }

    @Test
    void testVerhoeffCheck_EmptyString() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class,
            () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_NonDigitInput1() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("123A5"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInput2() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("12 34"));
    }

    @Test
    void testVerhoeffCheck_NonDigitInput3() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("12-34"));
    }

    @Test
    void testVerhoeffCheck_LongValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("98765432101234567890"));
    }

    @Test
    void testVerhoeffCheck_LongInvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("98765432101234567891"));
    }
}
// ```
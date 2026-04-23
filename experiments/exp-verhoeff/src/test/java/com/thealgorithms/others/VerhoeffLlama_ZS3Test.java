package com.thealgorithms.others;

// ```java
import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffLlama_ZS3Test {

    @Test
    public void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
    }

    @Test
    public void testVerhoeffCheck_ValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_InvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    public void testVerhoeffCheck_SingleDigitInput() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }
}
// ```
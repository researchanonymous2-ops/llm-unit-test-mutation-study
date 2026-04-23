package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_POT3Test {

    private final Range<Integer> range = Range.between(5, 10);

    @Test
    void testElementCompareTo_Null() {
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_Before() {
        assertEquals(-1, range.elementCompareTo(4));
    }

    @Test
    void testElementCompareTo_After() {
        assertEquals(1, range.elementCompareTo(11));
    }

    @Test
    void testElementCompareTo_Inside() {
        assertEquals(0, range.elementCompareTo(5));
        assertEquals(0, range.elementCompareTo(7));
        assertEquals(0, range.elementCompareTo(10));
    }
}
// ```
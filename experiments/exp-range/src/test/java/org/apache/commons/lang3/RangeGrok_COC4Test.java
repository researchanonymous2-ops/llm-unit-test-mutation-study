package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.apache.commons.lang3.Range;

public class RangeGrok_COC4Test {

    @Test
    public void testElementCompareTo_Null() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    public void testElementCompareTo_Before() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    public void testElementCompareTo_After() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(15));
    }

    @Test
    public void testElementCompareTo_Inside() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
        assertEquals(0, range.elementCompareTo(5));
        assertEquals(0, range.elementCompareTo(10));
    }
}
// ```
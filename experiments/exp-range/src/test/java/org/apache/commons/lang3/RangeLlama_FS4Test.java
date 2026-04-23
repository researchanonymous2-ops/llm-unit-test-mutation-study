package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeLlama_FS4Test {

    @Test
    void testElementCompareTo_InsideRange() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_BeforeRange() {
        Range<Integer> range = Range.between(3, 8);
        assertEquals(-1, range.elementCompareTo(1));
    }

    @Test
    void testElementCompareTo_AfterRange() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(1, range.elementCompareTo(8));
    }

    @Test
    void testElementCompareTo_Minimum() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(0, range.elementCompareTo(2));
    }

    @Test
    void testElementCompareTo_Maximum() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(0, range.elementCompareTo(6));
    }

    @Test
    void testElementCompareTo_NullThrowsException() {
        Range<Integer> range = Range.between(2, 6);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_SingletonRange() {
        Range<Integer> range = Range.is(5);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_ReversedRange() {
        Range<Integer> range = Range.between(8, 3);
        assertEquals(0, range.elementCompareTo(5));
        assertEquals(-1, range.elementCompareTo(1));
        assertEquals(1, range.elementCompareTo(9));
    }
}
// ```
package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.Range;

public class RangeGrok_POT4Test {

    @Test
    void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_ElementBefore() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_ElementAfter() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(15));
    }

    @Test
    void testElementCompareTo_ElementInside() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }

    @Test
    void testElementCompareTo_ElementAtMinimum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_ElementAtMaximum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(10));
    }
}
// ```
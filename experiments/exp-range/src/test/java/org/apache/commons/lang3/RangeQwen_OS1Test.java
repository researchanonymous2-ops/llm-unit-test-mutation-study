package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeQwen_OS1Test {

    @Test
    void testElementCompareTo_elementBeforeRange_returnsMinusOne() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_elementAfterRange_returnsOne() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(15));
    }

    @Test
    void testElementCompareTo_elementWithinRange_returnsZero() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }

    @Test
    void testElementCompareTo_elementEqualToMinimum_returnsZero() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_elementEqualToMaximum_returnsZero() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(10));
    }

    @Test
    void testElementCompareTo_elementJustBeforeMinimum_returnsMinusOne() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(4));
    }

    @Test
    void testElementCompareTo_elementJustAfterMaximum_returnsOne() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(11));
    }

    @Test
    void testElementCompareTo_nullElement_throwsNullPointerException() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_singleElementRange_elementLessThan_returnsMinusOne() {
        Range<Integer> range = Range.is(7);
        assertEquals(-1, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_singleElementRange_elementGreaterThan_returnsOne() {
        Range<Integer> range = Range.is(7);
        assertEquals(1, range.elementCompareTo(9));
    }

    @Test
    void testElementCompareTo_singleElementRange_elementEqual_returnsZero() {
        Range<Integer> range = Range.is(7);
        assertEquals(0, range.elementCompareTo(7));
    }
}
// ```
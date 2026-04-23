package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeQwen_ZS3Test {

    @Test
    public void testElementCompareTo_ElementBeforeRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    public void testElementCompareTo_ElementAfterRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(15));
    }

    @Test
    public void testElementCompareTo_ElementWithinRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMinimum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMaximum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(10));
    }

    @Test
    public void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    public void testElementCompareTo_SingleElementRange_ElementBefore() {
        Range<Integer> range = Range.is(5);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    public void testElementCompareTo_SingleElementRange_ElementAfter() {
        Range<Integer> range = Range.is(5);
        assertEquals(1, range.elementCompareTo(7));
    }

    @Test
    public void testElementCompareTo_SingleElementRange_ElementEqual() {
        Range<Integer> range = Range.is(5);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    public void testElementCompareTo_ReverseRangeDefinition() {
        Range<Integer> range = Range.between(10, 5);
        assertEquals(-1, range.elementCompareTo(3));
        assertEquals(1, range.elementCompareTo(15));
        assertEquals(0, range.elementCompareTo(7));
    }
}
// ```
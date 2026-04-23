package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class RangeQwen_ZS2Test {

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
    public void testElementCompareTo_ElementBeforeRangeWithCustomComparator() {
        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        Range<String> range = Range.between("abc", "abcdef", lengthComparator);
        assertEquals(-1, range.elementCompareTo("a"));
    }

    @Test
    public void testElementCompareTo_ElementAfterRangeWithCustomComparator() {
        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        Range<String> range = Range.between("abc", "abcdef", lengthComparator);
        assertEquals(1, range.elementCompareTo("abcdefgh"));
    }

    @Test
    public void testElementCompareTo_ElementWithinRangeWithCustomComparator() {
        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        Range<String> range = Range.between("abc", "abcdef", lengthComparator);
        assertEquals(0, range.elementCompareTo("abcd"));
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
    public void testElementCompareTo_ReversedRangeDefinition() {
        Range<Integer> range = Range.between(10, 5); // Should normalize to 5..10
        assertEquals(-1, range.elementCompareTo(3));
        assertEquals(1, range.elementCompareTo(15));
        assertEquals(0, range.elementCompareTo(7));
    }
}
// ```
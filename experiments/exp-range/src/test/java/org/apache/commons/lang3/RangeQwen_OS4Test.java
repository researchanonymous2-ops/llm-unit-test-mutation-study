package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeQwen_OS4Test {

    @Test
    void testElementCompareTo_ElementWithinRange() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_ElementAtMinimum() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(1));
    }

    @Test
    void testElementCompareTo_ElementAtMaximum() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(10));
    }

    @Test
    void testElementCompareTo_ElementBeforeRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_ElementAfterRange() {
        Range<Integer> range = Range.between(1, 8);
        assertEquals(1, range.elementCompareTo(12));
    }

    @Test
    void testElementCompareTo_SingleElementRangeSameValue() {
        Range<Integer> range = Range.is(5);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    void testElementCompareTo_SingleElementRangeDifferentValueBelow() {
        Range<Integer> range = Range.is(5);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_SingleElementRangeDifferentValueAbove() {
        Range<Integer> range = Range.is(5);
        assertEquals(1, range.elementCompareTo(7));
    }

    @Test
    void testElementCompareTo_NegativeNumbersInRange() {
        Range<Integer> range = Range.between(-10, -1);
        assertEquals(0, range.elementCompareTo(-5));
    }

    @Test
    void testElementCompareTo_NegativeNumbersOutsideRangeBelow() {
        Range<Integer> range = Range.between(-5, -1);
        assertEquals(-1, range.elementCompareTo(-10));
    }

    @Test
    void testElementCompareTo_NegativeNumbersOutsideRangeAbove() {
        Range<Integer> range = Range.between(-10, -5);
        assertEquals(1, range.elementCompareTo(0));
    }

    @Test
    void testElementCompareTo_StringRangeElementWithin() {
        Range<String> range = Range.between("apple", "orange");
        assertEquals(0, range.elementCompareTo("banana"));
    }

    @Test
    void testElementCompareTo_StringRangeElementBefore() {
        Range<String> range = Range.between("mango", "zebra");
        assertEquals(-1, range.elementCompareTo("apple"));
    }

    @Test
    void testElementCompareTo_StringRangeElementAfter() {
        Range<String> range = Range.between("apple", "banana");
        assertEquals(1, range.elementCompareTo("cherry"));
    }

    @Test
    void testElementCompareTo_NullElementThrowsException() {
        Range<Integer> range = Range.between(1, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_EqualToBoundsMin() {
        Range<Double> range = Range.between(2.5, 7.5);
        assertEquals(0, range.elementCompareTo(2.5));
    }

    @Test
    void testElementCompareTo_EqualToBoundsMax() {
        Range<Double> range = Range.between(2.5, 7.5);
        assertEquals(0, range.elementCompareTo(7.5));
    }

    @Test
    void testElementCompareTo_LargeRangeElementWithin() {
        Range<Long> range = Range.between(1L, 999999999999L);
        assertEquals(0, range.elementCompareTo(500000000000L));
    }

    @Test
    void testElementCompareTo_CharacterRange() {
        Range<Character> range = Range.between('a', 'z');
        assertEquals(0, range.elementCompareTo('m'));
    }

    @Test
    void testElementCompareTo_CharacterRangeBefore() {
        Range<Character> range = Range.between('g', 'p');
        assertEquals(-1, range.elementCompareTo('a'));
    }

    @Test
    void testElementCompareTo_CharacterRangeAfter() {
        Range<Character> range = Range.between('b', 'f');
        assertEquals(1, range.elementCompareTo('z'));
    }
}
// ```
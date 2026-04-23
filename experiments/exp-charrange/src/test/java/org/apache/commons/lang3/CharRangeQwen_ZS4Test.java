package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_ZS4Test {

    @Test
    public void testContains_nullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_rangeWithin() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('c', 'f');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_rangeOutside() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('x', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_partialOverlap() {
        CharRange range1 = CharRange.isIn('a', 'm');
        CharRange range2 = CharRange.isIn('m', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_disjoint() {
        CharRange range1 = CharRange.isIn('a', 'm');
        CharRange range2 = CharRange.isIn('n', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_sameRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharWithin() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('m');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharOutside() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('A');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_superset() {
        CharRange range1 = CharRange.isNotIn('c', 'f');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_notSuperset() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'f');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_sameRange() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_noOverlap() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('A', 'Z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_overlap() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('m', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_partialOverlap() {
        CharRange range1 = CharRange.isNotIn('m', 'z');
        CharRange range2 = CharRange.isIn('m', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_singleCharOverlap() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.is('m');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_singleCharNoOverlap() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.is('A');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_fullRange() {
        CharRange range1 = CharRange.isIn((char)0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_notFullRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'f');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_singleChar() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNot('m');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_singleCharSuperset() {
        CharRange range1 = CharRange.isNot('m');
        CharRange range2 = CharRange.isNot('m');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_singleCharNotSuperset() {
        CharRange range1 = CharRange.isNot('a');
        CharRange range2 = CharRange.isNot('m');
        assertFalse(range1.contains(range2));
    }
}
// ```
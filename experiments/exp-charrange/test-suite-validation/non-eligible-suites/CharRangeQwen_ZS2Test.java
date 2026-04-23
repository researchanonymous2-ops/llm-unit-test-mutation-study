package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_ZS2Test {

    @Test
    public void testContains_nullRange_throwsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_rangeWithinRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('c', 'f');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_rangeOutsideRange() {
        CharRange range1 = CharRange.isIn('a', 'm');
        CharRange range2 = CharRange.isIn('n', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_partialOverlap() {
        CharRange range1 = CharRange.isIn('a', 'm');
        CharRange range2 = CharRange.isIn('l', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_sameRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharInRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('m');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharAtStart() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('a');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharAtEnd() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharBefore() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('0');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_singleCharAfter() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('}');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_rangeWithinRange() {
        CharRange range1 = CharRange.isNotIn('c', 'p');
        CharRange range2 = CharRange.isNotIn('d', 'o');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_rangeOutsideRange() {
        CharRange range1 = CharRange.isNotIn('a', 'f');
        CharRange range2 = CharRange.isNotIn('g', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_partialOverlap() {
        CharRange range1 = CharRange.isNotIn('a', 'm');
        CharRange range2 = CharRange.isNotIn('l', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_sameRange() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_singleCharInRange() {
        CharRange range1 = CharRange.isNotIn('b', 'y');
        CharRange range2 = CharRange.isNot('m');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_singleCharAtStart() {
        CharRange range1 = CharRange.isNotIn('b', 'z');
        CharRange range2 = CharRange.isNot('b');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_singleCharAtEnd() {
        CharRange range1 = CharRange.isNotIn('a', 'y');
        CharRange range2 = CharRange.isNot('y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_disjoint() {
        CharRange range1 = CharRange.isNotIn('g', 's');
        CharRange range2 = CharRange.isIn('a', 'f');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_overlapping() {
        CharRange range1 = CharRange.isNotIn('g', 's');
        CharRange range2 = CharRange.isIn('f', 'h');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_subset() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_entireRange() {
        CharRange range1 = CharRange.isNot('a');
        CharRange range2 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_subset() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_entireSet() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNot('a');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_partial() {
        CharRange range1 = CharRange.isIn('a', 'm');
        CharRange range2 = CharRange.isNotIn('n', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_singleCharInRange() {
        CharRange range1 = CharRange.isNotIn('b', 'y');
        CharRange range2 = CharRange.is('a');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_singleCharOutsideRange() {
        CharRange range1 = CharRange.isNotIn('b', 'y');
        CharRange range2 = CharRange.is('c');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_singleCharInRange() {
        CharRange range1 = CharRange.isIn('b', 'y');
        CharRange range2 = CharRange.isNot('c');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_singleCharOutsideRange() {
        CharRange range1 = CharRange.isIn('b', 'y');
        CharRange range2 = CharRange.isNot('a');
        assertFalse(range1.contains(range2));
    }
}
// ```
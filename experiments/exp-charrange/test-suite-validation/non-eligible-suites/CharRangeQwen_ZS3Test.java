package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_ZS3Test {

    @Test
    public void testContains_nullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_completelyInside() {
        CharRange range1 = CharRange.isIn('b', 'd');
        CharRange range2 = CharRange.isIn('a', 'e');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_partialOverlap() {
        CharRange range1 = CharRange.isIn('c', 'f');
        CharRange range2 = CharRange.isIn('a', 'd');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_noOverlap() {
        CharRange range1 = CharRange.isIn('e', 'f');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_sameRange() {
        CharRange range1 = CharRange.isIn('a', 'd');
        CharRange range2 = CharRange.isIn('a', 'd');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_adjacent() {
        CharRange range1 = CharRange.isIn('d', 'e');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNegated_completelyInside() {
        CharRange range1 = CharRange.isNotIn('a', 'e');
        CharRange range2 = CharRange.isNotIn('b', 'd');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNegated_partialOverlap() {
        CharRange range1 = CharRange.isNotIn('c', 'f');
        CharRange range2 = CharRange.isNotIn('a', 'd');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNegated_noOverlap() {
        CharRange range1 = CharRange.isNotIn('e', 'f');
        CharRange range2 = CharRange.isNotIn('a', 'c');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNegated_sameRange() {
        CharRange range1 = CharRange.isNotIn('a', 'd');
        CharRange range2 = CharRange.isNotIn('a', 'd');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNonNegated_noOverlap() {
        CharRange range1 = CharRange.isIn('c', 'd');
        CharRange range2 = CharRange.isNotIn('a', 'e');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNonNegated_partialOverlap() {
        CharRange range1 = CharRange.isIn('a', 'c');
        CharRange range2 = CharRange.isNotIn('b', 'd');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNonNegated_completelyInside() {
        CharRange range1 = CharRange.isIn('b', 'c');
        CharRange range2 = CharRange.isNotIn('a', 'd');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_negatedContainsNonNegated_sameBoundaries() {
        CharRange range1 = CharRange.isIn('a', 'd');
        CharRange range2 = CharRange.isNotIn('a', 'd');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_fullRange() {
        CharRange range1 = CharRange.isNotIn('b', 'c');
        CharRange range2 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_notFullRange() {
        CharRange range1 = CharRange.isNotIn('b', 'c');
        CharRange range2 = CharRange.isIn('a', 'd');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_singleCharNonNegatedInNonNegated() {
        CharRange range1 = CharRange.is('b');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertTrue(range2.contains(range1));
    }

    @Test
    public void testContains_singleCharNonNegatedNotInNonNegated() {
        CharRange range1 = CharRange.is('d');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_singleCharNegated() {
        CharRange range1 = CharRange.isNot('b');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertFalse(range2.contains(range1));
    }

    @Test
    public void testContains_edgeCaseMaxRange() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range2.contains(range1));
        assertTrue(range1.contains(range2));
    }
}
// ```
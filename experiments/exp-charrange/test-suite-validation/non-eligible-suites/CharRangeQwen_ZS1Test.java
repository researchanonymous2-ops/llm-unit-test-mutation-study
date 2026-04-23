package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_ZS1Test {

    @Test
    public void testContains_nullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_True() {
        CharRange range1 = CharRange.isIn('a', 'e');
        CharRange range2 = CharRange.isIn('b', 'd');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNonNegated_False() {
        CharRange range1 = CharRange.isIn('a', 'e');
        CharRange range2 = CharRange.isIn('d', 'g');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_False() {
        CharRange range1 = CharRange.isIn('a', 'e');
        CharRange range2 = CharRange.isNotIn('b', 'd');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsFullNegated_False() {
        CharRange range1 = CharRange.isIn('a', 'e');
        CharRange range2 = CharRange.isNotIn((char) 0, Character.MAX_VALUE);
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_True() {
        CharRange range1 = CharRange.isNotIn('c', 'd');
        CharRange range2 = CharRange.isIn('a', 'b');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_False() {
        CharRange range1 = CharRange.isNotIn('a', 'd');
        CharRange range2 = CharRange.isIn('b', 'c');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_True() {
        CharRange range1 = CharRange.isNotIn('a', 'f');
        CharRange range2 = CharRange.isNotIn('b', 'e');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_False() {
        CharRange range1 = CharRange.isNotIn('b', 'e');
        CharRange range2 = CharRange.isNotIn('a', 'f');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedFullRangeContainsNegated_True() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedNotFullRangeContainsNegated_False() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_sameRangeNonNegated_True() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_sameRangeNegated_True() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_singleCharInMultiChar_True() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('m');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_singleCharNotInMultiChar_False() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.is('0');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_disjointRanges_False() {
        CharRange range1 = CharRange.isIn('a', 'f');
        CharRange range2 = CharRange.isIn('k', 'p');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_adjacentRanges_False() {
        CharRange range1 = CharRange.isIn('a', 'f');
        CharRange range2 = CharRange.isIn('g', 'l');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_overlappingButNotContained_False() {
        CharRange range1 = CharRange.isIn('c', 'm');
        CharRange range2 = CharRange.isIn('a', 'e');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedAdjacent_False() {
        CharRange range1 = CharRange.isNotIn('a', 'f');
        CharRange range2 = CharRange.isIn('a', 'f');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedOverlapping_True() {
        CharRange range1 = CharRange.isNotIn('a', 'f');
        CharRange range2 = CharRange.isIn('g', 'l');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_emptyNegatedRange_True() {
        CharRange range1 = CharRange.isNotIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isIn('a', 'a');
        assertFalse(range1.contains(range2));
    }
}
// ```
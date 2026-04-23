package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_ZS5Test {

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
    public void testContains_nonNegatedContainsNegated_True() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_nonNegatedContainsNegated_False() {
        CharRange range1 = CharRange.isIn('b', 'y');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_True() {
        CharRange range1 = CharRange.isNotIn('f', 'j');
        CharRange range2 = CharRange.isIn('a', 'e');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNonNegated_False() {
        CharRange range1 = CharRange.isNotIn('a', 'e');
        CharRange range2 = CharRange.isIn('c', 'g');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_True() {
        CharRange range1 = CharRange.isNotIn('a', 'e');
        CharRange range2 = CharRange.isNotIn('b', 'd');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_negatedContainsNegated_False() {
        CharRange range1 = CharRange.isNotIn('b', 'd');
        CharRange range2 = CharRange.isNotIn('a', 'e');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_sameRangeNonNegated() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_sameRangeNegated() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_edgeCaseStartEqualEnd() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.is('a');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_edgeCaseFullRange() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }
}
// ```
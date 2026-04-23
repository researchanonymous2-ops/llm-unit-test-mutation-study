package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_ZS5Test {

    @Test
    public void testContains_NullRange() {
        final CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_SameRange() {
        final CharRange range1 = CharRange.isIn('a', 'z');
        final CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_SubRange() {
        final CharRange range1 = CharRange.isIn('a', 'z');
        final CharRange range2 = CharRange.isIn('m', 'p');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_SuperRange() {
        final CharRange range1 = CharRange.isIn('m', 'p');
        final CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_DisjointRange() {
        final CharRange range1 = CharRange.isIn('a', 'f');
        final CharRange range2 = CharRange.isIn('h', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_PartiallyOverlappingRange() {
        final CharRange range1 = CharRange.isIn('a', 'm');
        final CharRange range2 = CharRange.isIn('h', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_NegatedRange_Contained() {
        final CharRange range1 = CharRange.isNotIn('a', 'z');
        final CharRange range2 = CharRange.isIn('0', '9');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_NegatedRange_NotContained() {
        final CharRange range1 = CharRange.isNotIn('a', 'z');
        final CharRange range2 = CharRange.isIn('A', 'Z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_RangeContainedInNegated() {
        final CharRange range1 = CharRange.isIn('a', 'z');
        final CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated() {
        final CharRange range1 = CharRange.isNotIn('a', 'z');
        final CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_UniversalRange() {
        final CharRange range1 = CharRange.isIn('\0', Character.MAX_VALUE);
        final CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_EmptyRange() {
        final CharRange range1 = CharRange.isIn('a', 'a');
        final CharRange range2 = CharRange.isNotIn('a', 'a');
        assertTrue(range1.contains(range1));
        assertTrue(range2.contains(range2));
    }
}
// ```
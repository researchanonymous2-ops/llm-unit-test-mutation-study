package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_ZS2Test {

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
        final CharRange range2 = CharRange.isIn('g', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_PartialOverlapRange() {
        final CharRange range1 = CharRange.isIn('a', 'm');
        final CharRange range2 = CharRange.isIn('g', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_NegatedRange() {
        final CharRange range1 = CharRange.isIn('a', 'z');
        final CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_NegatedRange2() {
        final CharRange range1 = CharRange.isNotIn('a', 'z');
        final CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_UniversalRange() {
        final CharRange range1 = CharRange.isNotIn((char) 0, (char) 0);
        final CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }
}
// ```
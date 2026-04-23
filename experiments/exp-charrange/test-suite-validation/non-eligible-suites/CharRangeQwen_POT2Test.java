package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_POT2Test {

    @Test
    public void testContains_NullRange_ThrowsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_BothNegated_TrueWhenThisContainsRange() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated_FalseWhenThisDoesNotContainRange() {
        CharRange range1 = CharRange.isNotIn('c', 'x');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegatedRangeNotNegated_TrueWhenNoOverlap() {
        CharRange range1 = CharRange.isNotIn('d', 'w');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegatedRangeNotNegated_FalseWhenOverlap() {
        CharRange range1 = CharRange.isNotIn('d', 'w');
        CharRange range2 = CharRange.isIn('a', 'e');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegatedRangeNegated_TrueWhenFullRange() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegatedRangeNegated_FalseWhenNotFullRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'x');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_TrueWhenThisContainsRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('c', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_FalseWhenThisDoesNotContainRange() {
        CharRange range1 = CharRange.isIn('c', 'x');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }
}
// ```
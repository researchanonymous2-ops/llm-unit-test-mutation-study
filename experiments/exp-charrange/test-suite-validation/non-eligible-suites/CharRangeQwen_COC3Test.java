package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_COC3Test {

    @Test
    public void testContains_NullRange_ThrowsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_BothNegated_True() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated_False() {
        CharRange range1 = CharRange.isNotIn('c', 'x');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegatedRangeNotNegated_NoOverlap_True() {
        CharRange range1 = CharRange.isNotIn('d', 'f');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegatedRangeNotNegated_Overlap_False() {
        CharRange range1 = CharRange.isNotIn('d', 'f');
        CharRange range2 = CharRange.isIn('e', 'g');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegatedRangeNegated_FullRange_True() {
        CharRange range1 = CharRange.isIn((char)0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegatedRangeNegated_NotFullRange_False() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'x');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_True() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('c', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_False() {
        CharRange range1 = CharRange.isIn('c', 'x');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }
}
// ```
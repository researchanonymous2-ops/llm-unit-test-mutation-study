package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_ZS3Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_SingleCharRange_Contained() {
        CharRange range1 = CharRange.is('a');
        CharRange range2 = CharRange.is('a');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_SingleCharRange_NotContained() {
        CharRange range1 = CharRange.is('a');
        CharRange range2 = CharRange.is('b');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_Range_Contained() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_Range_NotContained() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_NegatedRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_NegatedRange_Universal() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegatedRanges() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegatedRanges_Reversed() {
        CharRange range1 = CharRange.isNotIn('b', 'y');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }
}
// ```
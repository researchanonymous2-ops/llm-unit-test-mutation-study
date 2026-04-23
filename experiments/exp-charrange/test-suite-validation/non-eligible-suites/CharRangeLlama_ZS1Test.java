package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_ZS1Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_SameRange_NonNegated() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_SubRange_NonNegated() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_SuperRange_NonNegated() {
        CharRange range1 = CharRange.isIn('b', 'y');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_DisjointRange_NonNegated() {
        CharRange range1 = CharRange.isIn('a', 'm');
        CharRange range2 = CharRange.isIn('n', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_SameRange_Negated() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_SubRange_Negated() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_SuperRange_Negated() {
        CharRange range1 = CharRange.isNotIn('b', 'y');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_DisjointRange_Negated() {
        CharRange range1 = CharRange.isNotIn('a', 'm');
        CharRange range2 = CharRange.isNotIn('n', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_MixedNegation() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_UniversalRange() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }
}
// ```
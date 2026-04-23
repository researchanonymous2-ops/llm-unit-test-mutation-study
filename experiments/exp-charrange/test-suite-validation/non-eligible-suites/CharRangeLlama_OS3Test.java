package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_OS3Test {

    @Test
    void testContains_NullRange() {
        CharRange range = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_SameRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_SubRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('c', 'f');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_SuperRange() {
        CharRange range1 = CharRange.isIn('c', 'f');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_DisjointRange() {
        CharRange range1 = CharRange.isIn('a', 'f');
        CharRange range2 = CharRange.isIn('g', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_PartiallyOverlappingRange() {
        CharRange range1 = CharRange.isIn('a', 'g');
        CharRange range2 = CharRange.isIn('f', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_NegatedRange_ContainingAll() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_NegatedRange_NotContainingAll() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_NegatedOuterRange() {
        CharRange outer = CharRange.isNotIn('c', 'f');
        CharRange inner = CharRange.isIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_BothNegated() {
        CharRange range1 = CharRange.isNotIn('a', 'f');
        CharRange range2 = CharRange.isNotIn('c', 'z');
        assertTrue(range2.contains(range1));
    }

    @Test
    void testContains_InnerNegated() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('c', 'f');
        assertFalse(outer.contains(inner));
    }
}
// ```
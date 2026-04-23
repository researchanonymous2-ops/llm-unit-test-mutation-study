package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_OS5Test {

    @Test
    void testContains_NullRange() {
        CharRange range = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_SameRange() {
        CharRange range = CharRange.isIn('a', 'z');
        assertTrue(range.contains(range));
    }

    @Test
    void testContains_SubRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('c', 'f');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_SuperRange() {
        CharRange inner = CharRange.isIn('a', 'z');
        CharRange outer = CharRange.isIn('c', 'f');
        assertFalse(inner.contains(outer));
    }

    @Test
    void testContains_DisjointRange() {
        CharRange range1 = CharRange.isIn('a', 'f');
        CharRange range2 = CharRange.isIn('h', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_NegatedRange_ContainsNonNegated() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange negatedRange = CharRange.isNotIn('c', 'f');
        assertFalse(range.contains(negatedRange));
    }

    @Test
    void testContains_NonNegatedRange_ContainsNegated() {
        CharRange negatedRange = CharRange.isNotIn('a', 'z');
        CharRange range = CharRange.isIn('c', 'f');
        assertTrue(negatedRange.contains(range));
    }

    @Test
    void testContains_BothNegatedRanges() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('c', 'f');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_UniversalNegatedRange() {
        CharRange universalNegated = CharRange.isNotIn(Character.MIN_VALUE, Character.MAX_VALUE);
        CharRange anyRange = CharRange.isIn('a', 'z');
        assertFalse(universalNegated.contains(anyRange));
    }

    @Test
    void testContains_EmptyNegatedRange() {
        CharRange emptyNegated = CharRange.isNotIn('a', 'a');
        CharRange anyRange = CharRange.isIn('a', 'z');
        assertFalse(emptyNegated.contains(anyRange));
    }

    @Test
    void testContains_RangeContainsUniversalNegated() {
        CharRange universalRange = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        CharRange negatedRange = CharRange.isNotIn('a', 'z');
        assertTrue(universalRange.contains(negatedRange));
    }
}
// ```
package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_OS2Test {

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
        assertFalse(range2.contains(range1));
    }

    @Test
    void testContains_NegatedRange_ContainsNonNegated() {
        CharRange range1 = CharRange.isNotIn('a', 'f');
        CharRange range2 = CharRange.isIn('c', 'd');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_NonNegatedRange_ContainsNegated() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'd');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_NegatedRange_ContainsNegated() {
        CharRange outer = CharRange.isNotIn('g', 'j');
        CharRange inner = CharRange.isNotIn('h', 'i');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_UniversalNegatedRange() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange universalNegated = CharRange.isNotIn(Character.MIN_VALUE, Character.MAX_VALUE);
        assertFalse(range.contains(universalNegated));
    }

    @Test
    void testContains_EmptyNegatedRange() {
        CharRange range = CharRange.isNotIn('a', 'a');
        CharRange universal = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        assertTrue(universal.contains(range));
    }
}
// ```
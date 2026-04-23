package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_OS4Test {

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
        CharRange negated = CharRange.isNotIn('a', 'z');
        CharRange nonNegated = CharRange.isIn('c', 'f');
        assertFalse(negated.contains(nonNegated));
    }

    @Test
    void testContains_NonNegatedRange_ContainsNegated() {
        CharRange nonNegated = CharRange.isIn('a', 'z');
        CharRange negated = CharRange.isNotIn('c', 'f');
        assertFalse(nonNegated.contains(negated));
    }

    @Test
    void testContains_NegatedRange_ContainsNegated() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('c', 'f');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_UniversalRange() {
        CharRange universal = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        CharRange any = CharRange.isIn('a', 'z');
        assertTrue(universal.contains(any));
    }

    @Test
    void testContains_EmptyRange() {
        CharRange range = CharRange.isIn('a', 'a');
        CharRange empty = CharRange.isNotIn('a', 'z');
        assertTrue(range.contains(empty));
    }
}
// ```
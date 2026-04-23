package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_OS1Test {

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
    void testContains_NegatedRange_ContainingAll() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('a', 'z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedRange_Empty() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isNotIn('a', 'z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_BothNegated_SubRange() {
        CharRange outer = CharRange.isNotIn('c', 'f');
        CharRange inner = CharRange.isNotIn('d', 'e');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_BothNegated_SuperRange() {
        CharRange inner = CharRange.isNotIn('c', 'f');
        CharRange outer = CharRange.isNotIn('d', 'e');
        assertFalse(inner.contains(outer));
    }

    @Test
    void testContains_OneCharacterRange() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('a');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedOneCharacterRange() {
        CharRange range = CharRange.isNot('a');
        CharRange other = CharRange.is('a');
        assertFalse(range.contains(other));
    }
}
// ```
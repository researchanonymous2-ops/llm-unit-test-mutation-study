package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_FS1Test {

    @Test
    void testContains_NullRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
    }

    @Test
    void testContains_SameRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_InnerRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterRange() {
        CharRange outer = CharRange.isIn('b', 'y');
        CharRange inner = CharRange.isIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_DisjointRange() {
        CharRange outer = CharRange.isIn('a', 'm');
        CharRange inner = CharRange.isIn('n', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_NegatedOuterRange() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_NegatedInnerRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_BothNegatedRanges() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_UniversalRange() {
        CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange inner = CharRange.isIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_EmptyRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'a');
        assertTrue(outer.contains(inner));
    }
}
// ```
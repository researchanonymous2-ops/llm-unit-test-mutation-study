package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_OS5Test {

    @Test
    void testContains_nullRange_throwsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_nonNegatedContainsNonNegated_rangeWithin() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('c', 'f');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedContainsNonNegated_rangeOutside() {
        CharRange outer = CharRange.isIn('a', 'e');
        CharRange inner = CharRange.isIn('f', 'j');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedContainsNonNegated_partialOverlap() {
        CharRange outer = CharRange.isIn('a', 'e');
        CharRange inner = CharRange.isIn('d', 'h');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedContainsNonNegated_exactMatch() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedContainsNegated_fullUniverse() {
        CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedContainsNegated_notFullUniverse() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('c', 'f');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedContainsNonNegated_disjoint() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isIn('0', '9');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedContainsNonNegated_overlapping() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isIn('x', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedContainsNonNegated_partialOverlap() {
        CharRange outer = CharRange.isNotIn('a', 'e');
        CharRange inner = CharRange.isIn('d', 'h');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedContainsNegated_superset() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('c', 'f');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedContainsNegated_notSuperset() {
        CharRange outer = CharRange.isNotIn('c', 'f');
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedContainsNegated_disjointRanges() {
        CharRange outer = CharRange.isNotIn('a', 'e');
        CharRange inner = CharRange.isNotIn('f', 'j');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNonNegatedContainsSingleCharNonNegated_sameChar() {
        CharRange outer = CharRange.is('a');
        CharRange inner = CharRange.is('a');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNonNegatedContainsSingleCharNonNegated_differentChar() {
        CharRange outer = CharRange.is('a');
        CharRange inner = CharRange.is('b');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNegatedContainsSingleCharNegated_sameChar() {
        CharRange outer = CharRange.isNot('a');
        CharRange inner = CharRange.isNot('a');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNegatedContainsSingleCharNegated_differentChar() {
        CharRange outer = CharRange.isNot('a');
        CharRange inner = CharRange.isNot('b');
        assertFalse(outer.contains(inner));
    }
}
// ```
package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_OS2Test {

    @Test
    void testContains_nullRange_throwsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_nonNegatedRangeContainsNonNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('c', 'f');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeDoesNotContainNonNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'd');
        CharRange inner = CharRange.isIn('c', 'f');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeContainsNegatedRange() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainNegatedRange() {
        CharRange outer = CharRange.isNotIn('b', 'y');
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeContainsNegatedRange() {
        CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange inner = CharRange.isNot('a');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeDoesNotContainNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNot('c');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeContainsNonNegatedRange_disjointAtStart() {
        CharRange outer = CharRange.isNotIn('a', 'd');
        CharRange inner = CharRange.isIn('e', 'h');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeContainsNonNegatedRange_disjointAtEnd() {
        CharRange outer = CharRange.isNotIn('w', 'z');
        CharRange inner = CharRange.isIn('a', 't');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainNonNegatedRange_overlapping() {
        CharRange outer = CharRange.isNotIn('c', 'f');
        CharRange inner = CharRange.isIn('d', 'g');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_identicalNonNegatedRanges() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_identicalNegatedRanges() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNonNegatedContainedInRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.is('m');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNonNegatedNotContainedInRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.is('0');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNegatedRangeContainedInNegatedOuter() {
        CharRange outer = CharRange.isNotIn('a', 'e');
        CharRange inner = CharRange.isNot('c');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNegatedRangeNotContainedInNegatedOuter() {
        CharRange outer = CharRange.isNotIn('b', 'd');
        CharRange inner = CharRange.isNot('a');
        assertFalse(outer.contains(inner));
    }
}
// ```
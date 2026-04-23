package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeQwen_FS1Test {

    @Test
    void testContains_nullRange_throwsException() {
        CharRange range = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_nonNegatedRangeContainsNonNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('c', 'x');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeDoesNotContainNonNegatedRange() {
        CharRange outer = CharRange.isIn('c', 'x');
        CharRange inner = CharRange.isIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeContainsSingleCharNonNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.is('m');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeDoesNotContainSingleCharNonNegatedRange() {
        CharRange outer = CharRange.isIn('c', 'x');
        CharRange inner = CharRange.is('a');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeContainsNegatedRange() {
        CharRange outer = CharRange.isNotIn('d', 'w');
        CharRange inner = CharRange.isNotIn('c', 'x');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainNegatedRange() {
        CharRange outer = CharRange.isNotIn('c', 'x');
        CharRange inner = CharRange.isNotIn('d', 'w');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeContainsSingleCharNegatedRange() {
        CharRange outer = CharRange.isNotIn('b', 'y');
        CharRange inner = CharRange.isNot('m');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainSingleCharNegatedRange() {
        CharRange outer = CharRange.isNotIn('c', 'x');
        CharRange inner = CharRange.isNot('b');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_nonNegatedRangeContainsNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_fullRangeContainsNegatedRange() {
        CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange inner = CharRange.isNotIn('m', 'p');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeContainsNonNegatedRange_noOverlap() {
        CharRange outer = CharRange.isNotIn('g', 's');
        CharRange inner = CharRange.isIn('a', 'c');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainNonNegatedRange_overlapping() {
        CharRange outer = CharRange.isNotIn('g', 's');
        CharRange inner = CharRange.isIn('c', 'k');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainNonNegatedRange_fullyContained() {
        CharRange outer = CharRange.isNotIn('g', 's');
        CharRange inner = CharRange.isIn('i', 'p');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_negatedRangeDoesNotContainNonNegatedRange_partialRightOverlap() {
        CharRange outer = CharRange.isNotIn('g', 's');
        CharRange inner = CharRange.isIn('o', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_identicalNonNegatedRanges() {
        CharRange outer = CharRange.isIn('b', 'y');
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_identicalNegatedRanges() {
        CharRange outer = CharRange.isNotIn('c', 'x');
        CharRange inner = CharRange.isNotIn('c', 'x');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNonNegatedRangeInLargerNonNegatedRange() {
        CharRange outer = CharRange.isIn('a', 'e');
        CharRange inner = CharRange.is('c');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_singleCharNegatedRangeInLargerNegatedRange() {
        CharRange outer = CharRange.isNotIn('a', 'c');
        CharRange inner = CharRange.isNot('b');
        assertTrue(outer.contains(inner));
    }
}
// ```
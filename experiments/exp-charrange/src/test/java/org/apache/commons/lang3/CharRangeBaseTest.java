package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharRangeBaseTest {

    @Test
    void testContains_withNonNegatedRangeContained() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('c', 'f');

        outer.contains(inner);
    }

    @Test
    void testContains_withNonNegatedRangeNotContained() {
        CharRange outer = CharRange.isIn('a', 'm');
        CharRange inner = CharRange.isIn('n', 'z');

        outer.contains(inner);
    }

    @Test
    void testContains_withBothNegatedRanges() {
        CharRange outer = CharRange.isNotIn('c', 'f');
        CharRange inner = CharRange.isNotIn('d', 'e');

        outer.contains(inner);
    }

    @Test
    void testContains_withNegatedOuterAndNormalInner() {
        CharRange outer = CharRange.isNotIn('c', 'f');
        CharRange inner = CharRange.isIn('a', 'b');

        outer.contains(inner);
    }

    @Test
    void testContains_withNormalOuterAndNegatedInner() {
        CharRange outer = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange inner = CharRange.isNotIn('a', 'z');

        outer.contains(inner);
    }

    @Test
    void testContains_withNullRange() {
        CharRange outer = CharRange.isIn('a', 'z');

        assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
    }
}


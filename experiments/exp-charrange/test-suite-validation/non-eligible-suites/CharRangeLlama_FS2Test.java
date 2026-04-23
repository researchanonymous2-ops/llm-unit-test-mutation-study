package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_FS2Test {

    @Test
    void testContains_NullRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
    }

    @Test
    void testContains_OuterNotNegated_InnerNotNegated() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNotNegated_InnerNegated() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNotNegated() {
        CharRange outer = CharRange.isNotIn('m', 'p');
        CharRange inner = CharRange.isIn('a', 'c');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNegated() {
        CharRange outer = CharRange.isNotIn('m', 'p');
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNotNegated_InnerNotNegated_PartiallyContained() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('y', '~');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNotNegated_CompletelyOutside() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isIn('1', '9');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNotNegated_InnerNotNegated_SameRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNegated_SameRange() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertTrue(outer.contains(inner));
    }
}
// ```
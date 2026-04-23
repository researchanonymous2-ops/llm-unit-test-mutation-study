package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeLlama_FS4Test {

    @Test
    void testContains_NullRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
    }

    @Test
    void testContains_OuterNotNegated_InnerNotNegated_InnerContained() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNotNegated_InnerNotNegated_InnerNotContained() {
        CharRange outer = CharRange.isIn('b', 'y');
        CharRange inner = CharRange.isIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNotNegated_InnerNegated() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNotNegated_InnerNegated_FullRange() {
        CharRange outer = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNotNegated_Disjoint() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNotNegated_NotDisjoint() {
        CharRange outer = CharRange.isNotIn('b', 'y');
        CharRange inner = CharRange.isIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNegated() {
        CharRange outer = CharRange.isNotIn('b', 'y');
        CharRange inner = CharRange.isNotIn('c', 'x');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_OuterNegated_InnerNegated_OuterContainedInInner() {
        CharRange outer = CharRange.isNotIn('c', 'x');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertTrue(outer.contains(inner));
    }
}
// ```
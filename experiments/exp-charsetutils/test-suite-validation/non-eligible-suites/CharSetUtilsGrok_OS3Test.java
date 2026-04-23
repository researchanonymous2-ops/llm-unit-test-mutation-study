package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_OS3Test {

   @Test
   void testSqueeze_NullString() {
       assertEquals(null, CharSetUtils.squeeze(null, "a"));
   }

   @Test
   void testSqueeze_EmptyString() {
       assertEquals("", CharSetUtils.squeeze("", "a"));
   }

   @Test
   void testSqueeze_NullSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
   }

   @Test
   void testSqueeze_EmptySet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", ""));
   }

   @Test
   void testSqueeze_NoRepetitions() {
       assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
   }

   @Test
   void testSqueeze_WithRepetitionsInSet() {
       assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
   }

   @Test
   void testSqueeze_WithRepetitionsNotInSet() {
       assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
   }

   @Test
   void testSqueeze_SingleCharacter() {
       assertEquals("a", CharSetUtils.squeeze("a", "a"));
   }

   @Test
   void testSqueeze_AllRepetitions() {
       assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
   }

   @Test
   void testSqueeze_MultipleSets() {
       assertEquals("heo", CharSetUtils.squeeze("hello", "l", "o"));
   }

   @Test
   void testSqueeze_CaseSensitive() {
       assertEquals("Hello", CharSetUtils.squeeze("HHello", "H"));
   }

   @Test
   void testSqueeze_SpecialCharacters() {
       assertEquals("a!b", CharSetUtils.squeeze("a!!b", "!"));
   }
}

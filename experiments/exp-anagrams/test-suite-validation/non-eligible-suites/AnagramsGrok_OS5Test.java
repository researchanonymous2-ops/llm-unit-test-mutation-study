package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_OS5Test {

  @Test
  void testApproach2_TrueForAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("listen", "silent"));
  }

  @Test
  void testApproach2_TrueForEmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_TrueForSingleCharacter() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("a", "a"));
  }

  @Test
  void testApproach2_TrueForRepeatedCharacters() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("aabb", "abab"));
  }

  @Test
  void testApproach2_FalseForDifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "ab"));
  }

  @Test
  void testApproach2_FalseForNonAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("hello", "world"));
  }

  @Test
  void testApproach2_FalseForSameLengthDifferentChars() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("abc", "def"));
  }

  @Test
  void testApproach2_FalseForCaseSensitivity() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("Listen", "silent"));
  }
}

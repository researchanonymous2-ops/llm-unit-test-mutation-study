package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsQwen_OS4Test {

  @Test
  void testApproach2_validAnagram_lowercase() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("listen", "silent"));
  }

  @Test
  void testApproach2_validAnagram_mixedCase() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("evil", "vile"));
  }

  @Test
  void testApproach2_invalidAnagram_differentLength() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("hello", "hell"));
  }

  @Test
  void testApproach2_invalidAnagram_sameLengthDifferentChars() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("apple", "table"));
  }

  @Test
  void testApproach2_validAnagram_withRepeatedCharacters() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("aabbcc", "abcabc"));
  }

  @Test
  void testApproach2_invalidAnagram_withRepeatedCharacters() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("aabbc", "aabbcc"));
  }

  @Test
  void testApproach2_validAnagram_identicalStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("test", "test"));
  }

  @Test
  void testApproach2_emptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_singleCharacter_same() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("a", "a"));
  }

  @Test
  void testApproach2_singleCharacter_different() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "b"));
  }
}

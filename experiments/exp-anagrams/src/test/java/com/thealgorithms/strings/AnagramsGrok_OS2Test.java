package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_OS2Test {

  @Test
  void testApproach2_ListenSilent() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("listen", "silent"));
  }

  @Test
  void testApproach2_DealLead() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("deal", "lead"));
  }

  @Test
  void testApproach2_EmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_SameString() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("abc", "abc"));
  }

  @Test
  void testApproach2_SingleCharacter() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("a", "a"));
  }

  @Test
  void testApproach2_WithRepeats() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("aabb", "abab"));
  }

  @Test
  void testApproach2_NotAnagramSameLength() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("abc", "def"));
  }

  @Test
  void testApproach2_DifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "ab"));
  }

  @Test
  void testApproach2_EmptyVsNonEmpty() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("", "a"));
  }

  @Test
  void testApproach2_SingleDifferent() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "b"));
  }

  @Test
  void testApproach2_WithRepeatsNotAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("aabb", "aaab"));
  }
}

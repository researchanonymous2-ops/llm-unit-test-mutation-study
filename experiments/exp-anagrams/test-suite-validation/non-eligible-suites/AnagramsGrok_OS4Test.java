package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_OS4Test {

  @Test
  void testApproach2_EmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_SingleCharacterSame() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("a", "a"));
  }

  @Test
  void testApproach2_SingleCharacterDifferent() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "b"));
  }

  @Test
  void testApproach2_DifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "ab"));
  }

  @Test
  void testApproach2_SimpleAnagram() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("listen", "silent"));
  }

  @Test
  void testApproach2_NotAnagramSameLength() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("hello", "world"));
  }

  @Test
  void testApproach2_WithRepeatsTrue() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.aproach2("aab", "aba"));
  }

  @Test
  void testApproach2_WithRepeatsFalse() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("aab", "abc"));
  }

  @Test
  void testApproach2_LongerAnagram() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("anagram", "nagaram"));
  }

  @Test
  void testApproach2_LongerNotAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("anagram", "different"));
  }
}

package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_FS3Test {

  @Test
  void testApproach2_Anagrams() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("earth", "heart"));
  }

  @Test
  void testApproach2_NotAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("apple", "banana"));
  }

  @Test
  void testApproach2_DifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("cat", "cats"));
  }

  @Test
  void testApproach2_EmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_SameString() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("test", "test"));
  }

  @Test
  void testApproach2_SingleCharacter() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("a", "a"));
  }

  @Test
  void testApproach2_SingleCharacterDifferent() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "b"));
  }

  @Test
  void testApproach2_RepeatedCharacters() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("aabb", "bbaa"));
  }

  @Test
  void testApproach2_RepeatedCharactersNotAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("aabb", "aaab"));
  }
}

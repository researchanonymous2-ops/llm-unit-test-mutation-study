package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_FS2Test {

  @Test
  void testApproach2_WithValidAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("earth", "heart"));
  }

  @Test
  void testApproach2_WithEmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_WithDifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("test", "testing"));
  }

  @Test
  void testApproach2_WithSameLengthButNotAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("apple", "grape"));
  }

  @Test
  void testApproach2_WithIdenticalStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("radar", "radar"));
  }

  @Test
  void testApproach2_WithUppercaseLetters() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("Listen", "Silent"));
  }

  @Test
  void testApproach2_WithNumbers() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("123", "321"));
  }

  @Test
  void testApproach2_WithSpecialCharacters() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a!b", "b!a"));
  }
}

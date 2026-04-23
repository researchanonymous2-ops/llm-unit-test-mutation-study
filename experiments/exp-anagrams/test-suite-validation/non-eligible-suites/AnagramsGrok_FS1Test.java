package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_FS1Test {

  @Test
  void testApproach2_ValidAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("earth", "heart"));
  }

  @Test
  void testApproach2_EmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_DifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("test", "testing"));
  }

  @Test
  void testApproach2_SameLengthNotAnagrams() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("apple", "grape"));
  }

  @Test
  void testApproach2_SingleCharacterMatch() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("a", "a"));
  }

  @Test
  void testApproach2_SingleCharacterNoMatch() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a", "b"));
  }

  @Test
  void testApproach2_WithSpaces() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a b", "ab"));
  }

  @Test
  void testApproach2_CaseSensitive() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("Abc", "abc"));
  }

  @Test
  void testApproach2_RepeatedCharacters() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("aabbcc", "ccbbaa"));
  }

  @Test
  void testApproach2_NonAnagramsRepeated() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("aabbcc", "aabbcd"));
  }
}

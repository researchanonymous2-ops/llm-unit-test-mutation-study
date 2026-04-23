package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_FS5Test {

  @Test
  void testApproach2_EmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_OneEmptyOneNot() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("", "a"));
  }

  @Test
  void testApproach2_SimpleAnagram() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("abc", "cba"));
  }

  @Test
  void testApproach2_SameLengthNotAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("aab", "abb"));
  }

  @Test
  void testApproach2_DifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("abcd", "abc"));
  }

  @Test
  void testApproach2_LongerAnagram() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("triangle", "integral"));
  }

  @Test
  void testApproach2_LongerNotAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("triangle", "integralx"));
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
}

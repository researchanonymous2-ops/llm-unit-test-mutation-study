package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_FS4Test {

  @Test
  void testApproach2_AnagramStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("triangle", "integral"));
  }

  @Test
  void testApproach2_DifferentLengths() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("test", "testing"));
  }

  @Test
  void testApproach2_SameLengthNonAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("apple", "grape"));
  }

  @Test
  void testApproach2_EmptyStrings() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("", ""));
  }

  @Test
  void testApproach2_SingleCharacterMatch() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("z", "z"));
  }

  @Test
  void testApproach2_SingleCharacterMismatch() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("x", "y"));
  }

  @Test
  void testApproach2_UppercaseLetters() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("Listen", "Silent"));
  }

  @Test
  void testApproach2_WithSpaces() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("a b c", "abc"));
  }

  @Test
  void testApproach2_LongAnagram() {
      Anagrams anagrams = new Anagrams();
      assertTrue(anagrams.approach2("dormitory", "dirtyroom"));
  }

  @Test
  void testApproach2_LongNonAnagram() {
      Anagrams anagrams = new Anagrams();
      assertFalse(anagrams.approach2("conversation", "conservation"));
  }
}

package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_OS1Test {

   @Test
   void testVerhoeffCheck_ValidInput() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_InvalidInput() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
   }

   @Test
   void testVerhoeffCheck_ValidLongInput() {
       assertTrue(Verhoeff.verhoeffCheck("123456789012"));
   }

   @Test
   void testVerhoeffCheck_InvalidLongInput() {
       assertFalse(Verhoeff.verhoeffCheck("123456789013"));
   }

   @Test
   void testVerhoeffCheck_SingleDigitValid() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_SingleDigitInvalid() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }

   @Test
   void testVerhoeffCheck_NullInput() {
       assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_NonDigitInput() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
   }

   @Test
   void testVerhoeffCheck_EmptyString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_MixedInput() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
   }
}

package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;

public class PrimesQwen_OS5Test {

   @Test
   void testNextPrime_negativeInput() {
       assertThrows(org.apache.commons.math3.exception.MathIllegalArgumentException.class, () -> {
           Primes.nextPrime(-5);
       });
   }

   @Test
   void testNextPrime_zero() {
       assertEquals(2, Primes.nextPrime(0));
   }

   @Test
   void testNextPrime_one() {
       assertEquals(2, Primes.nextPrime(1));
   }

   @Test
   void testNextPrime_two() {
       assertEquals(2, Primes.nextPrime(2));
   }

   @Test
   void testNextPrime_three() {
       assertEquals(3, Primes.nextPrime(3));
   }

   @Test
   void testNextPrime_four() {
       assertEquals(5, Primes.nextPrime(4));
   }

   @Test
   void testNextPrime_largeNonPrime() {
       assertEquals(101, Primes.nextPrime(99));
   }

   @Test
   void testNextPrime_largePrime() {
       assertEquals(97, Primes.nextPrime(97));
   }

   @Test
   void testNextPrime_edgeCaseBeforeLargeGap() {
       assertEquals(29, Primes.nextPrime(28));
   }

   @Test
   void testNextPrime_afterSmallGap() {
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   void testNextPrime_middleValue() {
       assertEquals(53, Primes.nextPrime(50));
   }

   @Test
   void testNextPrime_powerOfTwo() {
       assertEquals(17, Primes.nextPrime(16));
   }

}

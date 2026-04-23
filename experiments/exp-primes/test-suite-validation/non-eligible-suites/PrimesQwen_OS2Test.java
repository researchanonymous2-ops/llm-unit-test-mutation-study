package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesQwen_OS2Test {

   @Test
   void testNextPrime_negativeInput() {
       assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
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
   void testNextPrime_edgeCaseBeforeBigJump() {
       assertEquals(23, Primes.nextPrime(22));
   }

   @Test
   void testNextPrime_middleValue() {
       assertEquals(19, Primes.nextPrime(17));
   }
}

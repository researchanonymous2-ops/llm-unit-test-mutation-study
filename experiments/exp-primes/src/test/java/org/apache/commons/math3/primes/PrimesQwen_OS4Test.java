package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesQwen_OS4Test {

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
   void testNextPrime_smallNonPrime() {
       assertEquals(7, Primes.nextPrime(6));
   }

   @Test
   void testNextPrime_smallPrime() {
       assertEquals(11, Primes.nextPrime(11));
   }

   @Test
   void testNextPrime_largerNonPrime() {
       assertEquals(101, Primes.nextPrime(99));
   }

   @Test
   void testNextPrime_largerPrime() {
       assertEquals(97, Primes.nextPrime(97));
   }

   @Test
   void testNextPrime_squareOfPrime() {
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   void testNextPrime_paddedNonPrime() {
       assertEquals(1009, Primes.nextPrime(1000));
   }
}

package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.junit.jupiter.api.Test;

public class PrimesGrok_OS1Test {

   @Test
   void testNextPrime_Negative() {
       assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
   }

   @Test
   void testNextPrime_Zero() {
       assertEquals(2, Primes.nextPrime(0));
   }

   @Test
   void testNextPrime_One() {
       assertEquals(2, Primes.nextPrime(1));
   }

   @Test
   void testNextPrime_Two() {
       assertEquals(2, Primes.nextPrime(2));
   }

   @Test
   void testNextPrime_Three() {
       assertEquals(3, Primes.nextPrime(3));
   }

   @Test
   void testNextPrime_Four() {
       assertEquals(5, Primes.nextPrime(4));
   }

   @Test
   void testNextPrime_Five() {
       assertEquals(5, Primes.nextPrime(5));
   }

   @Test
   void testNextPrime_Six() {
       assertEquals(7, Primes.nextPrime(6));
   }

   @Test
   void testNextPrime_Eight() {
       assertEquals(11, Primes.nextPrime(8));
   }

   @Test
   void testNextPrime_Nine() {
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   void testNextPrime_Ten() {
       assertEquals(11, Primes.nextPrime(10));
   }

   @Test
   void testNextPrime_Eleven() {
       assertEquals(11, Primes.nextPrime(11));
   }

   @Test
   void testNextPrime_Twelve() {
       assertEquals(13, Primes.nextPrime(12));
   }

   @Test
   void testNextPrime_Fifteen() {
       assertEquals(17, Primes.nextPrime(15));
   }

   @Test
   void testNextPrime_Sixteen() {
       assertEquals(17, Primes.nextPrime(16));
   }

   @Test
   void testNextPrime_Seventeen() {
       assertEquals(17, Primes.nextPrime(17));
   }

   @Test
   void testNextPrime_Eighteen() {
       assertEquals(19, Primes.nextPrime(18));
   }

   @Test
   void testNextPrime_Twenty() {
       assertEquals(23, Primes.nextPrime(20));
   }

   @Test
   void testNextPrime_TwentyOne() {
       assertEquals(23, Primes.nextPrime(21));
   }

   @Test
   void testNextPrime_TwentyTwo() {
       assertEquals(23, Primes.nextPrime(22));
   }

   @Test
   void testNextPrime_TwentyThree() {
       assertEquals(23, Primes.nextPrime(23));
   }

   @Test
   void testNextPrime_TwentyFour() {
       assertEquals(29, Primes.nextPrime(24));
   }
}

package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.junit.jupiter.api.Test;

public class PrimesGrok_OS4Test {

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
   void testNextPrime_Seven() {
       assertEquals(7, Primes.nextPrime(7));
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
   void testNextPrime_Thirteen() {
       assertEquals(13, Primes.nextPrime(13));
   }

   @Test
   void testNextPrime_Fourteen() {
       assertEquals(17, Primes.nextPrime(14));
   }

   @Test
   void testNextPrime_Hundred() {
       assertEquals(101, Primes.nextPrime(100));
   }
}

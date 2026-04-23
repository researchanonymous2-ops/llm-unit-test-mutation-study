package org.apache.commons.math3.primes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesGrok_ZS3Test {

   @Test
   public void testNextPrime_NegativeInput() {
       assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
   }

   @Test
   public void testNextPrime_Zero() {
       assertEquals(2, Primes.nextPrime(0));
   }

   @Test
   public void testNextPrime_One() {
       assertEquals(2, Primes.nextPrime(1));
   }

   @Test
   public void testNextPrime_Two() {
       assertEquals(2, Primes.nextPrime(2));
   }

   @Test
   public void testNextPrime_Three() {
       assertEquals(3, Primes.nextPrime(3));
   }

   @Test
   public void testNextPrime_Four() {
       assertEquals(5, Primes.nextPrime(4));
   }

   @Test
   public void testNextPrime_Five() {
       assertEquals(5, Primes.nextPrime(5));
   }

   @Test
   public void testNextPrime_Six() {
       assertEquals(7, Primes.nextPrime(6));
   }

   @Test
   public void testNextPrime_Seven() {
       assertEquals(7, Primes.nextPrime(7));
   }

   @Test
   public void testNextPrime_Eight() {
       assertEquals(11, Primes.nextPrime(8));
   }

   @Test
   public void testNextPrime_Nine() {
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   public void testNextPrime_Ten() {
       assertEquals(11, Primes.nextPrime(10));
   }

   @Test
   public void testNextPrime_Eleven() {
       assertEquals(11, Primes.nextPrime(11));
   }

   @Test
   public void testNextPrime_Twelve() {
       assertEquals(13, Primes.nextPrime(12));
   }

   @Test
   public void testNextPrime_Thirteen() {
       assertEquals(13, Primes.nextPrime(13));
   }

   @Test
   public void testNextPrime_Fourteen() {
       assertEquals(17, Primes.nextPrime(14));
   }

   @Test
   public void testNextPrime_Fifteen() {
       assertEquals(17, Primes.nextPrime(15));
   }

   @Test
   public void testNextPrime_Sixteen() {
       assertEquals(17, Primes.nextPrime(16));
   }

   @Test
   public void testNextPrime_Seventeen() {
       assertEquals(17, Primes.nextPrime(17));
   }

   @Test
   public void testNextPrime_Eighteen() {
       assertEquals(19, Primes.nextPrime(18));
   }

   @Test
   public void testNextPrime_Nineteen() {
       assertEquals(19, Primes.nextPrime(19));
   }

   @Test
   public void testNextPrime_Twenty() {
       assertEquals(23, Primes.nextPrime(20));
   }

   @Test
   public void testNextPrime_TwentyOne() {
       assertEquals(23, Primes.nextPrime(21));
   }

   @Test
   public void testNextPrime_TwentyTwo() {
       assertEquals(23, Primes.nextPrime(22));
   }

   @Test
   public void testNextPrime_TwentyThree() {
       assertEquals(23, Primes.nextPrime(23));
   }

   @Test
   public void testNextPrime_TwentyFour() {
       assertEquals(29, Primes.nextPrime(24));
   }

   @Test
   public void testNextPrime_TwentyFive() {
       assertEquals(29, Primes.nextPrime(25));
   }

   @Test
   public void testNextPrime_TwentySix() {
       assertEquals(29, Primes.nextPrime(26));
   }

   @Test
   public void testNextPrime_TwentySeven() {
       assertEquals(29, Primes.nextPrime(27));
   }

   @Test
   public void testNextPrime_TwentyEight() {
       assertEquals(29, Primes.nextPrime(28));
   }

   @Test
   public void testNextPrime_TwentyNine() {
       assertEquals(29, Primes.nextPrime(29));
   }

   @Test
   public void testNextPrime_Thirty() {
       assertEquals(31, Primes.nextPrime(30));
   }

}

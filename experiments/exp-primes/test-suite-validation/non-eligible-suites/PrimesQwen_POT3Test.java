package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesQwen_POT3Test {

    @Test
    public void testNextPrime_T0_negativeInput() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_T1_inputIsTwo() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_T2_inputIsOne() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_T3_primeInput() {
        int result = Primes.nextPrime(11);
        assertTrue(result >= 11);
        assertTrue(Primes.isPrime(result));
        assertEquals(11, result);
    }

    @Test
    public void testNextPrime_T4_remZero() {
        int result = Primes.nextPrime(15); // 15 % 3 == 0, so n becomes 17
        assertTrue(result >= 15);
        assertTrue(Primes.isPrime(result));
        assertEquals(17, result);
    }

    @Test
    public void testNextPrime_T5_remOne() {
        int result = Primes.nextPrime(13); // 13 % 3 == 1, so n becomes 17
        assertTrue(result >= 13);
        assertTrue(Primes.isPrime(result));
        assertEquals(17, result);
    }

    @Test
    public void testNextPrime_T6_remTwo() {
        int result = Primes.nextPrime(14); // 15 % 3 == 2, enters loop directly
        assertTrue(result >= 14);
        assertTrue(Primes.isPrime(result));
        assertEquals(17, result);
    }

    @Test
    public void testNextPrime_T7_firstCheckInLoop() {
        int result = Primes.nextPrime(25); // 25 % 3 == 1, so n becomes 29
        assertTrue(result >= 25);
        assertTrue(Primes.isPrime(result));
        assertEquals(29, result);
    }

    @Test
    public void testNextPrime_T8_secondCheckInLoop() {
        int result = Primes.nextPrime(19); // 19 is prime, but +2 = 21 (not prime), +4 = 25 (not prime), next +2 = 27 (not prime), +4 = 31 (prime)
        assertTrue(result >= 19);
        assertTrue(Primes.isPrime(result));
        assertEquals(31, result);
    }

    @Test
    public void testNextPrime_T9_fullLoopIteration() {
        int result = Primes.nextPrime(89); // 89 is prime, +2 = 91 (7*13), +4 = 95 (5*19), +2 = 97 (prime)
        assertTrue(result >= 89);
        assertTrue(Primes.isPrime(result));
        assertEquals(97, result);
    }
}
// ```
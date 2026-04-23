package org.apache.commons.math3.primes;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesGrok_POT4Test {

    @Test
    void testNextPrime_T0() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    void testNextPrime_T1() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    void testNextPrime_T2() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    void testNextPrime_T3() {
        int result = Primes.nextPrime(3);
        assertEquals(3, result);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 3);
    }

    @Test
    void testNextPrime_T4() {
        int result = Primes.nextPrime(9);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 9);
    }

    @Test
    void testNextPrime_T5() {
        int result = Primes.nextPrime(7);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 7);
    }

    @Test
    void testNextPrime_T6() {
        int result = Primes.nextPrime(65);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 65);
    }

    @Test
    void testNextPrime_T7() {
        int result = Primes.nextPrime(25);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 25);
    }

    @Test
    void testNextPrime_T8() {
        int result = Primes.nextPrime(49);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 49);
    }

    @Test
    void testNextPrime_T9() {
        int result = Primes.nextPrime(121);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 121);
    }
}
// ```
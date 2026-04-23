package org.apache.commons.math3.primes;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesGrok_POT3Test {

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
        assertTrue(result >= 3 && Primes.isPrime(result));
    }

    @Test
    void testNextPrime_T4() {
        int result = Primes.nextPrime(15);
        assertEquals(17, result);
        assertTrue(result >= 15 && Primes.isPrime(result));
    }

    @Test
    void testNextPrime_T5() {
        int result = Primes.nextPrime(25);
        assertEquals(29, result);
        assertTrue(result >= 25 && Primes.isPrime(result));
    }

    @Test
    void testNextPrime_T6() {
        int result = Primes.nextPrime(35);
        assertEquals(37, result);
        assertTrue(result >= 35 && Primes.isPrime(result));
    }

    @Test
    void testNextPrime_T7() {
        int result = Primes.nextPrime(45);
        assertEquals(47, result);
        assertTrue(result >= 45 && Primes.isPrime(result));
    }

    @Test
    void testNextPrime_T8() {
        int result = Primes.nextPrime(33);
        assertEquals(37, result);
        assertTrue(result >= 33 && Primes.isPrime(result));
    }

    @Test
    void testNextPrime_T9() {
        int result = Primes.nextPrime(119);
        assertEquals(127, result);
        assertTrue(result >= 119 && Primes.isPrime(result));
    }
}
// ```
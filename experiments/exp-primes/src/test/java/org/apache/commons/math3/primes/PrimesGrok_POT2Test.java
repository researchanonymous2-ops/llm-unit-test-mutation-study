package org.apache.commons.math3.primes;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesGrok_POT2Test {

    @Test
    public void testNextPrime_T0() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_T1() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_T2() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_T3() {
        int result = Primes.nextPrime(3);
        assertTrue(result >= 3 && Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T4() {
        int result = Primes.nextPrime(9);
        assertTrue(result >= 9 && Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T5() {
        int result = Primes.nextPrime(7);
        assertTrue(result >= 7 && Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T6() {
        int result = Primes.nextPrime(5);
        assertTrue(result >= 5 && Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T7() {
        int result = Primes.nextPrime(35);
        assertTrue(result >= 35 && Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T8() {
        int result = Primes.nextPrime(65);
        assertTrue(result >= 65 && Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T9() {
        int result = Primes.nextPrime(200);
        assertTrue(result >= 200 && Primes.isPrime(result));
    }
}
// ```
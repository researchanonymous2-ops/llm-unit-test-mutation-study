package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimesLlama_POT1Test {

    @Test
    public void testNextPrime_Negative() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_Two() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_One() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_Prime() {
        assertEquals(7, Primes.nextPrime(7));
    }

    @Test
    public void testNextPrime_NonPrime() {
        int n = 4;
        int nextPrime = Primes.nextPrime(n);
        assertTrue(nextPrime >= n);
        assertTrue(Primes.isPrime(nextPrime));
    }

    @Test
    public void testNextPrime_MultipleOfThree() {
        int n = 9; // n % 3 == 0
        int nextPrime = Primes.nextPrime(n);
        assertTrue(nextPrime >= n);
        assertTrue(Primes.isPrime(nextPrime));
    }

    @Test
    public void testNextPrime_RemOne() {
        int n = 10; // n % 3 == 1
        int nextPrime = Primes.nextPrime(n);
        assertTrue(nextPrime >= n);
        assertTrue(Primes.isPrime(nextPrime));
    }

    @Test
    public void testNextPrime_RemTwo() {
        int n = 11; // n % 3 == 2
        int nextPrime = Primes.nextPrime(n);
        assertTrue(nextPrime >= n);
        assertTrue(Primes.isPrime(nextPrime));
    }

    @Test
    public void testNextPrime_FirstIteration() {
        int n = 8; 
        int nextPrime = Primes.nextPrime(n);
        assertTrue(nextPrime >= n);
        assertTrue(Primes.isPrime(nextPrime));
    }

    @Test
    public void testNextPrime_SecondIteration() {
        int n = 14; 
        int nextPrime = Primes.nextPrime(n);
        assertTrue(nextPrime >= n);
        assertTrue(Primes.isPrime(nextPrime));
    }
}
// ```
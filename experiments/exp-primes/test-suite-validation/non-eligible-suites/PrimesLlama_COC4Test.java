package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimesLlama_COC4Test {

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
        assertEquals(7, Primes.nextPrime(6));
    }

    @Test
    public void testNextPrime_MultipleOfThree() {
        assertEquals(7, Primes.nextPrime(6));
    }

    @Test
    public void testNextPrime_RemainderOne() {
        assertEquals(7, Primes.nextPrime(5));
    }

    @Test
    public void testNextPrime_RemainderZero() {
        assertEquals(5, Primes.nextPrime(4));
    }
}
// ```
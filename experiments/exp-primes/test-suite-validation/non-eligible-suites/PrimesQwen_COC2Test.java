package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesQwen_COC2Test {

    @Test
    public void testNextPrime_negativeInput() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_two() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_one() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_oddPrime() {
        assertEquals(5, Primes.nextPrime(5));
    }

    @Test
    public void testNextPrime_evenNonPrime() {
        assertEquals(5, Primes.nextPrime(4));
    }

    @Test
    public void testNextPrime_remZero() {
        assertEquals(11, Primes.nextPrime(8));
    }

    @Test
    public void testNextPrime_remOne() {
        assertEquals(7, Primes.nextPrime(6));
    }

    @Test
    public void testNextPrime_loopPathFirstCheck() {
        assertEquals(11, Primes.nextPrime(9));
    }

    @Test
    public void testNextPrime_loopPathSecondCheck() {
        assertEquals(13, Primes.nextPrime(10));
    }

    @Test
    public void testNextPrime_loopFullIteration() {
        assertEquals(17, Primes.nextPrime(15));
    }
}
// ```
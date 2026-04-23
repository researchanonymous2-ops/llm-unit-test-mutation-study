package org.apache.commons.math3.primes;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesGrok_COC2Test {

    @Test
    public void testNextPrime_NegativeInput() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_EqualsTwo() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_EqualsOne() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_AlreadyPrimeOdd() {
        assertEquals(3, Primes.nextPrime(3));
    }

    @Test
    public void testNextPrime_RemZero() {
        assertEquals(11, Primes.nextPrime(9));
    }

    @Test
    public void testNextPrime_RemOne() {
        assertEquals(29, Primes.nextPrime(25));
    }

    @Test
    public void testNextPrime_LoopWithIncrementTwo() {
        assertEquals(37, Primes.nextPrime(35));
    }

    @Test
    public void testNextPrime_LoopWithIncrementFour() {
        assertEquals(127, Primes.nextPrime(119));
    }
}
// ```
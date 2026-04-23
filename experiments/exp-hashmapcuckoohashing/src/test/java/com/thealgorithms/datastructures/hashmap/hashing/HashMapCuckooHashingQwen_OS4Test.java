package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_OS4Test {

    @Test
    void testInsertKey2HashTable_SingleInsertion() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(42);
        assertTrue(map.checkTableContainsKey(42));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_MultipleInsertions() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        map.insertKey2HashTable(10);
        map.insertKey2HashTable(20);
        map.insertKey2HashTable(30);
        assertTrue(map.checkTableContainsKey(10));
        assertTrue(map.checkTableContainsKey(20));
        assertTrue(map.checkTableContainsKey(30));
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_DuplicateKeyThrowsException() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(5));
    }

    @Test
    void testInsertKey2HashTable_RehashingOccursWhenFull() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertDoesNotThrow(() -> map.insertKey2HashTable(3));
        assertTrue(map.checkTableContainsKey(1));
        assertTrue(map.checkTableContainsKey(2));
        assertTrue(map.checkTableContainsKey(3));
    }

    @Test
    void testInsertKey2HashTable_LoadFactorTriggeredRehash() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(5);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(4);
        assertDoesNotThrow(() -> map.insertKey2HashTable(5));
        assertTrue(map.checkTableContainsKey(5));
    }

    @Test
    void testInsertKey2HashTable_NegativeKeys() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(-15);
        map.insertKey2HashTable(-30);
        assertTrue(map.checkTableContainsKey(-15));
        assertTrue(map.checkTableContainsKey(-30));
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_ZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(0);
        assertTrue(map.checkTableContainsKey(0));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_LargeKeyValues() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        map.insertKey2HashTable(1000000);
        map.insertKey2HashTable(-1000000);
        assertTrue(map.checkTableContainsKey(1000000));
        assertTrue(map.checkTableContainsKey(-1000000));
        assertEquals(2, map.getNumberOfKeysInTable());
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingQwen_FS3Test {

    @Test
    void testInsertKey2HashTable_InsertSingleKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(42));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertMultipleKeys() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(10);
            map.insertKey2HashTable(20);
            map.insertKey2HashTable(30);
        });
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertDuplicateKeyThrowsException() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        map.insertKey2HashTable(50);
        assertThrows(IllegalArgumentException.class,
            () -> map.insertKey2HashTable(50));
    }

    @Test
    void testInsertKey2HashTable_InsertKeyInFullTableTriggersRehash() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(4);
        assertDoesNotThrow(() -> map.insertKey2HashTable(5));
    }

    @Test
    void testInsertKey2HashTable_InsertKeysWithSameHashFunction1() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(17);
            map.insertKey2HashTable(33);
            map.insertKey2HashTable(49);
        });
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertNegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(-15));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(0));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeyCausingInfiniteLoopScenario() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(9);
            map.insertKey2HashTable(17);
            map.insertKey2HashTable(25);
        });
        assertEquals(4, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeyAfterDeletion() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        map.insertKey2HashTable(100);
        map.deleteKeyFromHashTable(100);
        assertDoesNotThrow(() -> map.insertKey2HashTable(200));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeysUntilLoadFactorExceeded() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(2);
            map.insertKey2HashTable(3);
            map.insertKey2HashTable(4);
            map.insertKey2HashTable(5);
            map.insertKey2HashTable(6);
        });
        assertEquals(6, map.getNumberOfKeysInTable());
    }
}
// ```
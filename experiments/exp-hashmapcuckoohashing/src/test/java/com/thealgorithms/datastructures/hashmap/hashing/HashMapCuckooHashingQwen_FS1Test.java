package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingQwen_FS1Test {

    @Test
    void testInsertKey2HashTable_InsertSingleKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(42));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertMultipleUniqueKeys() {
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
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(50));
    }

    @Test
    void testInsertKey2HashTable_InsertKeyInFullTableTriggersRehash() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(2);
            map.insertKey2HashTable(3);
        });
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeysThatCauseCollision() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(5); // May collide depending on hash functions
        });
        assertEquals(2, map.getNumberOfKeysInTable());
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
    void testInsertKey2HashTable_InsertKeyEqualToTableSize() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> map.insertKey2HashTable(8));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeyWhenLoadFactorExceeded() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(2);
            map.insertKey2HashTable(3); // Should trigger rehash due to load factor
        });
        assertEquals(3, map.getNumberOfKeysInTable());
    }
}
// ```
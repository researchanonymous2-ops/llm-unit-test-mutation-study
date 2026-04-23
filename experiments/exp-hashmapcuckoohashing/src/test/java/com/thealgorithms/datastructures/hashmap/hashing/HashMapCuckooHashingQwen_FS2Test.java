package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;

public class HashMapCuckooHashingQwen_FS2Test {

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
            map.insertKey2HashTable(100);
            map.insertKey2HashTable(200);
            map.insertKey2HashTable(300);
        });
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertDuplicateKeyThrowsException() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        map.insertKey2HashTable(999);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(999));
    }

    @Test
    void testInsertKey2HashTable_InsertKeyInFullTableTriggersRehash() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertDoesNotThrow(() -> map.insertKey2HashTable(3));
    }

    @Test
    void testInsertKey2HashTable_InsertKeysWithSameHashFunction1() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(5);
            map.insertKey2HashTable(21);
        });
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeysWithSameHashFunction2() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(32);
            map.insertKey2HashTable(48);
        });
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertNegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(-123));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(0));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeyCausingLoadFactorRehash() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertDoesNotThrow(() -> map.insertKey2HashTable(4));
    }
}
// ```
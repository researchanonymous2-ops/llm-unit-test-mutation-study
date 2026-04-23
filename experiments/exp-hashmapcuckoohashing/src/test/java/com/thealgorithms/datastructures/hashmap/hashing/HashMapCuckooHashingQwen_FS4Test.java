package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingQwen_FS4Test {

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
    void testInsertKey2HashTable_InsertKeysThatCauseHighLoadFactorTriggersRehash() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(10);
            map.insertKey2HashTable(20);
            map.insertKey2HashTable(30);
        });
    }

    @Test
    void testInsertKey2HashTable_InsertNegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(-50));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(16);
        assertDoesNotThrow(() -> map.insertKey2HashTable(0));
        assertEquals(1, map.getNumberOfKeysInTable());
    }
}
// ```
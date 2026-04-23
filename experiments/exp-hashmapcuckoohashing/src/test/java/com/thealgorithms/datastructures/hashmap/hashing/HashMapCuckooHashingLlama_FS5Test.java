package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingLlama_FS5Test {

    @Test
    void testInsertKey2HashTable_SingleInsertion() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> map.insertKey2HashTable(10));
    }

    @Test
    void testInsertKey2HashTable_MultipleInsertions() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(5);
            map.insertKey2HashTable(13);
        });
    }

    @Test
    void testInsertKey2HashTable_DuplicateKeyThrowsException() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(7);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(7));
    }

    @Test
    void testInsertKey2HashTable_TableResize() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(2);
            map.insertKey2HashTable(3);
        });
    }

    @Test
    void testInsertKey2HashTable_ZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> map.insertKey2HashTable(0));
    }

    @Test
    void testInsertKey2HashTable_NegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> map.insertKey2HashTable(-10));
    }

    @Test
    void testInsertKey2HashTable_MaxIntKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> map.insertKey2HashTable(Integer.MAX_VALUE));
    }

    @Test
    void testInsertKey2HashTable_MinIntKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        assertDoesNotThrow(() -> map.insertKey2HashTable(Integer.MIN_VALUE));
    }
}
// ```
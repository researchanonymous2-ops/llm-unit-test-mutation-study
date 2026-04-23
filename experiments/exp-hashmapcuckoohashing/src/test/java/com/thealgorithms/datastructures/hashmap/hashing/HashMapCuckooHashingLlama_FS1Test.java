package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingLlama_FS1Test {

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
    void testInsertKey2HashTable_TableRehashing() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        assertDoesNotThrow(() -> {
            map.insertKey2HashTable(1);
            map.insertKey2HashTable(2);
            map.insertKey2HashTable(3);
        });
    }

    @Test
    void testInsertKey2HashTable_InsertIntoFullTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertDoesNotThrow(() -> map.insertKey2HashTable(3));
    }

    @Test
    void testInsertKey2HashTable_MultipleRehashing() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        for (int i = 0; i < 10; i++) {
            final int key = i;
            assertDoesNotThrow(() -> map.insertKey2HashTable(key));
        }
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingLlama_FS3Test {

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
    void testInsertKey2HashTable_InsertIntoFullTable_Rehashes() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertDoesNotThrow(() -> map.insertKey2HashTable(3));
    }

    @Test
    void testInsertKey2HashTable_InfiniteLoop_Rehashes() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(5);
        assertDoesNotThrow(() -> map.insertKey2HashTable(7));
    }

    @Test
    void testInsertKey2HashTable_LoadFactorCheck_Rehashes() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertDoesNotThrow(() -> map.insertKey2HashTable(4));
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HashMapCuckooHashingLlama_OS5Test {

    @Test
    void testInsertKey2HashTable_EmptyTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        assertFalse(map.isEmpty());
    }

    @Test
    void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(1));
    }

    @Test
    void testInsertKey2HashTable_FullTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertFalse(map.isFull());
    }

    @Test
    void testInsertKey2HashTable_MultipleInsertions() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertFalse(map.isEmpty());
    }

    @Test
    void testInsertKey2HashTable_Rehashing() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertTrue(map.getNumberOfKeysInTable() == 3);
    }
}
// ```
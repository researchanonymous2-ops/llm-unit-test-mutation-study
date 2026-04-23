package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapCuckooHashingLlama_OS4Test {

    @Test
    void testInsertKey2HashTable_EmptyTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(1));
    }

    @Test
    void testInsertKey2HashTable_FullTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(4);
        map.insertKey2HashTable(5);
        assertEquals(5, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_Collision() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(5); // Assuming hashFunction1(1) == hashFunction1(5)
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_Rehashing() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        for (int i = 0; i < 10; i++) {
            map.insertKey2HashTable(i);
        }
        assertEquals(10, map.getNumberOfKeysInTable());
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashMapCuckooHashingBaseTest {

    @Test
    void testInsertKey2HashTable_singleInsertion() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(10);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_multipleInsertions() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(13);
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_collisionPath() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(5); // força colisão no hashFunction1
        assertEquals(2, map.getNumberOfKeysInTable());
    }
}


package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingLlama_POT1Test {

    @Test
    public void testInsertKey2HashTable_TableFull() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertTrue(map.isFull());
        map.insertKey2HashTable(3);
        assertFalse(map.isFull());
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_DirectInsert() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(1);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_Relocation() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(3);
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_RehashAfterMaxIterations() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(5);
        assertEquals(3, map.getNumberOfKeysInTable());
    }
}
// ```
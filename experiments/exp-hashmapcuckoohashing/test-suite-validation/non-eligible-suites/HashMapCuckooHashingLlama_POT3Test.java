package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingLlama_POT3Test {

    @Test
    public void testInsertKey2HashTable_TableFull() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        assertTrue(hashMap.isFull());
        hashMap.insertKey2HashTable(3);
        assertEquals(4, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_DirectInsert() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_Relocation() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        hashMap.insertKey2HashTable(5);
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_RehashAfterThreshold() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        hashMap.insertKey2HashTable(5);
        hashMap.insertKey2HashTable(7);
        assertEquals(4, hashMap.getNumberOfKeysInTable());
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingGrok_POT4Test {

    @Test
    public void testInsertKey2HashTable_FullTableRehash() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        int originalSize = hashMap.tableSize;
        hashMap.insertKey2HashTable(3);
        assertTrue(hashMap.tableSize > originalSize);
        assertTrue(hashMap.checkTableContainsKey(3));
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(4);
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_DirectInsert() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(4);
        hashMap.insertKey2HashTable(1);
        assertTrue(hashMap.checkTableContainsKey(1));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_SimpleRelocation() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(4);
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(4);
        assertTrue(hashMap.checkTableContainsKey(0));
        assertTrue(hashMap.checkTableContainsKey(4));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InfiniteLoopRehash() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(2);
        int originalSize = hashMap.tableSize;
        hashMap.insertKey2HashTable(4);
        assertTrue(hashMap.tableSize > originalSize);
        assertTrue(hashMap.checkTableContainsKey(4));
    }
}
// ```
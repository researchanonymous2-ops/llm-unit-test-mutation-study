package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingGrok_COC3Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    void testInsertKey2HashTable_FullTable() {
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i);
        }
        int sizeBefore = hashMap.getNumberOfKeysInTable();
        hashMap.insertKey2HashTable(10);
        assertTrue(hashMap.getNumberOfKeysInTable() > sizeBefore);
        assertTrue(hashMap.checkTableContainsKey(10));
    }

    @Test
    void testInsertKey2HashTable_DuplicateKey() {
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    void testInsertKey2HashTable_SimpleInsert() {
        hashMap.insertKey2HashTable(1);
        assertEquals(1, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(1));
    }

    @Test
    void testInsertKey2HashTable_WithRelocation() {
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(10);
        assertEquals(2, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(0));
        assertTrue(hashMap.checkTableContainsKey(10));
    }

    @Test
    void testInsertKey2HashTable_InfiniteLoopRehash() {
        HashMapCuckooHashing smallHashMap = new HashMapCuckooHashing(2);
        smallHashMap.insertKey2HashTable(0);
        smallHashMap.insertKey2HashTable(2);
        int sizeBefore = smallHashMap.getNumberOfKeysInTable();
        smallHashMap.insertKey2HashTable(4);
        assertTrue(smallHashMap.getNumberOfKeysInTable() > sizeBefore);
        assertTrue(smallHashMap.checkTableContainsKey(4));
    }
}
// ```
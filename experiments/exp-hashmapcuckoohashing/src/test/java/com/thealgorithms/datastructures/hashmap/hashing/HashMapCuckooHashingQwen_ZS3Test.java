package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_ZS3Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    void testInsertKey2HashTable_InsertSingleKey() {
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertMultipleKeys() {
        hashMap.insertKey2HashTable(5);
        hashMap.insertKey2HashTable(15);
        hashMap.insertKey2HashTable(25);
        
        assertTrue(hashMap.checkTableContainsKey(5));
        assertTrue(hashMap.checkTableContainsKey(15));
        assertTrue(hashMap.checkTableContainsKey(25));
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertDuplicateKey() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    void testInsertKey2HashTable_InsertKeyInFullTable() {
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i * 10);
        }
        hashMap.insertKey2HashTable(100);
        assertTrue(hashMap.checkTableContainsKey(100));
    }

    @Test
    void testInsertKey2HashTable_InsertKeyCausingRehash() {
        for (int i = 0; i < 8; i++) {
            hashMap.insertKey2HashTable(i);
        }
        hashMap.insertKey2HashTable(8);
        assertTrue(hashMap.checkTableContainsKey(8));
    }

    @Test
    void testInsertKey2HashTable_InsertNegativeKey() {
        hashMap.insertKey2HashTable(-5);
        assertTrue(hashMap.checkTableContainsKey(-5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertZero() {
        hashMap.insertKey2HashTable(0);
        assertTrue(hashMap.checkTableContainsKey(0));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }
}
// ```
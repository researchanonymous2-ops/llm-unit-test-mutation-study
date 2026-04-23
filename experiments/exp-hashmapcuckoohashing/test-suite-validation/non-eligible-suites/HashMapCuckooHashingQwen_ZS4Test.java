package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_ZS4Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    public void testInsertKey2HashTable_InsertSingleKey() {
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertMultipleKeys() {
        hashMap.insertKey2HashTable(5);
        hashMap.insertKey2HashTable(10);
        hashMap.insertKey2HashTable(15);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertTrue(hashMap.checkTableContainsKey(10));
        assertTrue(hashMap.checkTableContainsKey(15));
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertDuplicateKey() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_InsertIntoFullTable() {
        hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        hashMap.insertKey2HashTable(3);
        assertTrue(hashMap.checkTableContainsKey(1));
        assertTrue(hashMap.checkTableContainsKey(2));
        assertTrue(hashMap.checkTableContainsKey(3));
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToLoadFactor() {
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        hashMap.insertKey2HashTable(3);
        hashMap.insertKey2HashTable(4);
        hashMap.insertKey2HashTable(5);
        hashMap.insertKey2HashTable(6);
        hashMap.insertKey2HashTable(7);
        hashMap.insertKey2HashTable(8);
        assertTrue(hashMap.checkTableContainsKey(1));
        assertTrue(hashMap.checkTableContainsKey(8));
        assertTrue(hashMap.getNumberOfKeysInTable() >= 8);
    }

    @Test
    public void testInsertKey2HashTable_NegativeKey() {
        hashMap.insertKey2HashTable(-5);
        assertTrue(hashMap.checkTableContainsKey(-5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_ZeroKey() {
        hashMap.insertKey2HashTable(0);
        assertTrue(hashMap.checkTableContainsKey(0));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }
}
// ```
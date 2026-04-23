package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_COC4Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    public void testInsertKey2HashTable_InsertIntoEmptyBucket() {
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertDuplicateKey() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_InsertWithCuckooRelocation() {
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(11); // Assuming 11 hashes to same index as 1 with h1
        assertTrue(hashMap.checkTableContainsKey(1));
        assertTrue(hashMap.checkTableContainsKey(11));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToThreshold() {
        // Fill the table to force threshold condition
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i * 10);
        }
        // This insertion should trigger rehash due to threshold
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToLoadFactor() {
        // Insert enough elements to exceed load factor of 0.7
        for (int i = 0; i < 8; i++) {
            hashMap.insertKey2HashTable(i);
        }
        assertTrue(hashMap.getNumberOfKeysInTable() > 0);
    }

    @Test
    public void testInsertKey2HashTable_InsertIntoFullTable() {
        // Manually fill the table to simulate full condition
        for (int i = 0; i < 10; i++) {
            hashMap.buckets[i] = i;
        }
        hashMap.size = 10;
        hashMap.insertKey2HashTable(100);
        assertTrue(hashMap.checkTableContainsKey(100));
    }
}
// ```
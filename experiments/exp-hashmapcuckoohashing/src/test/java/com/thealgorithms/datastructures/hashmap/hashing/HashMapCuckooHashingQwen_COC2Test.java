package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_COC2Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    void testInsertKey2HashTable_InsertIntoEmptyBucket() {
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertDuplicateKey() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    void testInsertKey2HashTable_InsertWithCollisionAtHash1() {
        hashMap.insertKey2HashTable(5);
        hashMap.insertKey2HashTable(15); // Assume 15 hashes to same index as 5 with hash1
        assertTrue(hashMap.checkTableContainsKey(5));
        assertTrue(hashMap.checkTableContainsKey(15));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertWithCollisionAtHash2() {
        hashMap.insertKey2HashTable(7);
        hashMap.insertKey2HashTable(17); // Assume 17 causes displacement via hash2
        assertTrue(hashMap.checkTableContainsKey(7));
        assertTrue(hashMap.checkTableContainsKey(17));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_RehashDueToInfiniteLoop() {
        // Fill the table to force rehashing
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i);
        }
        // This insertion should trigger rehashing due to high load factor or loop threshold
        hashMap.insertKey2HashTable(10);
        assertTrue(hashMap.checkTableContainsKey(10));
        assertTrue(hashMap.getNumberOfKeysInTable() > 5); // At least the inserted keys
    }

    @Test
    void testInsertKey2HashTable_RehashDueToFullTable() {
        // Manually fill the table to simulate full state
        for (int i = 0; i < 10; i++) {
            java.lang.reflect.Field bucketsField = null;
            try {
                bucketsField = HashMapCuckooHashing.class.getDeclaredField("buckets");
                bucketsField.setAccessible(true);
                Integer[] buckets = (Integer[]) bucketsField.get(hashMap);
                buckets[i] = i + 100; // Fill with non-null, non-AVAILABLE values
            } catch (Exception e) {
                fail("Reflection failed: " + e.getMessage());
            }
        }
        
        // Update size field to reflect full table
        try {
            java.lang.reflect.Field sizeField = HashMapCuckooHashing.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.set(hashMap, 10);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        hashMap.insertKey2HashTable(5); // Should trigger rehash and insert
        assertTrue(hashMap.checkTableContainsKey(5));
    }
}
// ```
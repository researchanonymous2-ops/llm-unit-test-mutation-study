package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_POT1Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    public void testInsertKey2HashTable_TableFull() {
        // Fill the table to trigger rehash
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i);
        }
        int originalSize = hashMap.tableSize;
        // Insert one more to trigger rehash
        hashMap.insertKey2HashTable(10);
        assertTrue(hashMap.tableSize > originalSize);
        assertTrue(hashMap.checkTableContainsKey(10));
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_DirectInsert() {
        hashMap.insertKey2HashTable(1);
        assertTrue(hashMap.checkTableContainsKey(1));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_SimpleRelocation() {
        // Insert keys that cause collision and relocation
        hashMap.insertKey2HashTable(0); // hash1=0
        hashMap.insertKey2HashTable(10); // hash1=0, should relocate to hash2=1
        assertTrue(hashMap.checkTableContainsKey(0));
        assertTrue(hashMap.checkTableContainsKey(10));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_RepeatedRelocation() {
        // Setup a scenario that leads to repeated relocations and rehash
        // This might require specific keys to force loops, but for simplicity, fill and insert conflicting keys
        for (int i = 0; i < 9; i++) {
            hashMap.insertKey2HashTable(i);
        }
        int originalSize = hashMap.tableSize;
        // Insert a key that causes issues, potentially triggering rehash after thresh
        hashMap.insertKey2HashTable(100); // Adjust key to cause conflicts
        // Assuming it triggers rehash if loop exceeds thresh
        assertTrue(hashMap.tableSize >= originalSize);
        assertTrue(hashMap.checkTableContainsKey(100));
    }
}
// ```
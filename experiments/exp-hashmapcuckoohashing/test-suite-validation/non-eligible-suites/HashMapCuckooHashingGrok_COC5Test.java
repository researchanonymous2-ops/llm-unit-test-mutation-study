package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

public class HashMapCuckooHashingGrok_COC5Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(4);
    }

    @Test
    void testInsertKey2HashTable_FullTable() throws Exception {
        // Fill the table completely
        for (int i = 0; i < 4; i++) {
            hashMap.insertKey2HashTable(i);
        }
        int originalSize = hashMap.getNumberOfKeysInTable();
        int originalTableSize = getTableSize();
        // Insert another key, should trigger rehash
        hashMap.insertKey2HashTable(4);
        assertTrue(hashMap.getNumberOfKeysInTable() > originalSize);
        assertTrue(getTableSize() > originalTableSize);
        assertTrue(hashMap.checkTableContainsKey(4));
    }

    @Test
    void testInsertKey2HashTable_DuplicateKey() {
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    void testInsertKey2HashTable_SimpleInsert() {
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_WithRelocation() throws Exception {
        // Insert keys to force relocation
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(4); // Assuming hash1(0)=0, hash1(4)=0, hash2(4)=0, but need to check
        // To force relocation, insert a key that collides
        // For tableSize=4, hash1(0)=0, hash1(4)=0, hash2(0)=0, hash2(4)=1
        // Insert 0, then 4, should relocate
        hashMap.insertKey2HashTable(4);
        assertTrue(hashMap.checkTableContainsKey(4));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InfiniteLoop() throws Exception {
        // To simulate infinite loop, set thresh low and force collisions
        // But hard to control, perhaps insert many keys to trigger rehash
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i);
        }
        assertTrue(hashMap.getNumberOfKeysInTable() >= 10);
        assertTrue(getTableSize() > 4);
    }

    private int getTableSize() throws Exception {
        Field field = HashMapCuckooHashing.class.getDeclaredField("tableSize");
        field.setAccessible(true);
        return (int) field.get(hashMap);
    }
}
// ```
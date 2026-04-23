package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_COC3Test {

    private HashMapCuckooHashing map;

    @BeforeEach
    void setUp() {
        map = new HashMapCuckooHashing(10);
    }

    @Test
    public void testInsertKey2HashTable_InsertIntoEmptyTable() {
        map.insertKey2HashTable(5);
        assertTrue(map.checkTableContainsKey(5));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertDuplicateKey() {
        map.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_InsertWithCollisionAtHash1() {
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(15); // Assume 15 hashes to same index as 5 with hashFunction1
        assertTrue(map.checkTableContainsKey(5));
        assertTrue(map.checkTableContainsKey(15));
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertWithDisplacement() {
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(15);
        map.insertKey2HashTable(25); // This might cause displacement
        assertTrue(map.checkTableContainsKey(5));
        assertTrue(map.checkTableContainsKey(15));
        assertTrue(map.checkTableContainsKey(25));
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToInfiniteLoop() {
        // Fill the table to force a rehash due to loop threshold
        for (int i = 0; i < 10; i++) {
            map.insertKey2HashTable(i * 10 + 1);
        }
        // This insertion should trigger rehash due to threshold
        map.insertKey2HashTable(111);
        assertTrue(map.checkTableContainsKey(111));
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToFullTable() {
        // Fill the table completely
        for (int i = 0; i < 10; i++) {
            map.insertKey2HashTable(i);
        }
        // Next insertion should trigger rehash due to full table
        map.insertKey2HashTable(10);
        assertTrue(map.checkTableContainsKey(10));
        assertTrue(map.getNumberOfKeysInTable() > 5); // Table should have grown
    }
}
// ```
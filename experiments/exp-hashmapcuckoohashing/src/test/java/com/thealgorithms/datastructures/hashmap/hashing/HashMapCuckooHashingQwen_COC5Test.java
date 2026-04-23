package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_COC5Test {

    @Test
    public void testInsertKey2HashTable_InsertIntoEmptyTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(5);
        assertTrue(map.checkTableContainsKey(5));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertDuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_InsertWithRelocationPathP2() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(5); 
        map.insertKey2HashTable(15); 
        assertTrue(map.checkTableContainsKey(5));
        assertTrue(map.checkTableContainsKey(15));
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertWithRelocationPathP3() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(9);
        assertTrue(map.checkTableContainsKey(1));
        assertTrue(map.checkTableContainsKey(5));
        assertTrue(map.checkTableContainsKey(9));
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashOnFullTablePathP0() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertDoesNotThrow(() -> map.insertKey2HashTable(3));
        assertTrue(map.checkTableContainsKey(3));
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToInfiniteLoopPathP4() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(3);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(6);
        map.insertKey2HashTable(9);
        assertDoesNotThrow(() -> map.insertKey2HashTable(12));
        assertTrue(map.checkTableContainsKey(12));
        assertEquals(4, map.getNumberOfKeysInTable());
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_ZS2Test {

    @Test
    public void testInsertKey2HashTable_InsertSingleKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(5);
        assertTrue(map.checkTableContainsKey(5));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertMultipleKeys() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(15);
        map.insertKey2HashTable(25);
        assertTrue(map.checkTableContainsKey(5));
        assertTrue(map.checkTableContainsKey(15));
        assertTrue(map.checkTableContainsKey(25));
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertDuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_InsertIntoFullTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3); // Should trigger rehashing
        assertTrue(map.checkTableContainsKey(1));
        assertTrue(map.checkTableContainsKey(2));
        assertTrue(map.checkTableContainsKey(3));
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_TriggerRehashDueToLoadFactor() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(5);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        map.insertKey2HashTable(4);
        assertTrue(map.checkTableContainsKey(1));
        assertTrue(map.checkTableContainsKey(2));
        assertTrue(map.checkTableContainsKey(3));
        assertTrue(map.checkTableContainsKey(4));
        assertEquals(4, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertNegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(-5);
        assertTrue(map.checkTableContainsKey(-5));
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InsertZero() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(0);
        assertTrue(map.checkTableContainsKey(0));
        assertEquals(1, map.getNumberOfKeysInTable());
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_OS3Test {

    @Test
    void testInsertKey2HashTable_InsertSingleKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(10);
        assertTrue(map.checkTableContainsKey(10));
    }

    @Test
    void testInsertKey2HashTable_InsertMultipleKeys() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(15);
        map.insertKey2HashTable(25);
        assertTrue(map.checkTableContainsKey(5));
        assertTrue(map.checkTableContainsKey(15));
        assertTrue(map.checkTableContainsKey(25));
    }

    @Test
    void testInsertKey2HashTable_InsertDuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(7);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(7));
    }

    @Test
    void testInsertKey2HashTable_TriggerRehashDueToLoadFactor() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertKeyInFullTable() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(100);
        map.insertKey2HashTable(200);
        map.insertKey2HashTable(300);
        assertTrue(map.checkTableContainsKey(100));
        assertTrue(map.checkTableContainsKey(200));
        assertTrue(map.checkTableContainsKey(300));
    }

    @Test
    void testInsertKey2HashTable_NegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(-5);
        assertTrue(map.checkTableContainsKey(-5));
    }

    @Test
    void testInsertKey2HashTable_ZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(0);
        assertTrue(map.checkTableContainsKey(0));
    }

    @Test
    void testInsertKey2HashTable_LargeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(1000000);
        assertTrue(map.checkTableContainsKey(1000000));
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingQwen_OS1Test {

    @Test
    void testInsertKey2HashTable_SingleElement() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(10);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_MultipleElementsNoCollision() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(8);
        map.insertKey2HashTable(5);
        map.insertKey2HashTable(6);
        map.insertKey2HashTable(7);
        assertEquals(3, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_DuplicateKeyThrowsException() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(15);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(15));
    }

    @Test
    void testInsertKey2HashTable_CausesRehashDueToLoadFactor() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(3);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2); 
        map.insertKey2HashTable(3);
        assertTrue(map.getNumberOfKeysInTable() >= 3);
    }

    @Test
    void testInsertKey2HashTable_NegativeKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(-5);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_ZeroKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(0);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_LargeKeyValue() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(4);
        map.insertKey2HashTable(999999);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_FullTableTriggersResize() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3);
        assertTrue(map.getNumberOfKeysInTable() >= 3);
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_POT2Test {

    @Test
    public void testInsertKey2HashTable_TableFull() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(3));
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_DirectInsertion() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(10);
        map.insertKey2HashTable(1);
        assertEquals(1, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_SimpleRelocation() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(3); // This will cause relocation
        assertEquals(2, map.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_RehashAfterThreshold() {
        HashMapCuckooHashing map = new HashMapCuckooHashing(2);
        map.insertKey2HashTable(1);
        map.insertKey2HashTable(2);
        map.insertKey2HashTable(3); // This will cause rehash
        assertEquals(3, map.getNumberOfKeysInTable());
    }
}
// ```
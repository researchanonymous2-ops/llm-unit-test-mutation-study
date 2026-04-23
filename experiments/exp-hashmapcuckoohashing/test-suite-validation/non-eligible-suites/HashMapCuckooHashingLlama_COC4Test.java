package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_COC4Test {

    @Test
    public void testInsertKey2HashTable_TableRehashedBeforeInsertion() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(3));
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_KeyInsertedWithoutRelocation() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_KeyInsertedWithRelocation() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InfiniteLoopOccurred() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        hashMap.insertKey2HashTable(5);
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }
}
// ```
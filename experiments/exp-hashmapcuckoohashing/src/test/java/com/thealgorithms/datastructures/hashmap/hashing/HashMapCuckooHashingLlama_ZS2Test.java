package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_ZS2Test {

    @Test
    public void testInsertKey2HashTable_NullTable() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(5);
        assertTrue(hashMap.checkTableContainsKey(5));
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_FullTable() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(1);
        hashMap.insertKey2HashTable(5);
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(10));
    }

    @Test
    public void testInsertKey2HashTable_InfiniteLoop() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_MultipleInsertions() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(5);
        hashMap.insertKey2HashTable(10);
        assertTrue(hashMap.checkTableContainsKey(5));
        assertTrue(hashMap.checkTableContainsKey(10));
    }
}
// ```
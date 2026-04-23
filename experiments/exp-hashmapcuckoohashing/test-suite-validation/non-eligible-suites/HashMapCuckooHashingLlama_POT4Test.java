package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_POT4Test {

    @Test
    public void testInsertKey2HashTable_TableFull() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        assertTrue(hashMap.isFull());
        assertThrows(Exception.class, () -> hashMap.insertKey2HashTable(3));
        assertEquals(4, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_DirectInsert() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_Relocation() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_Rehash() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        hashMap.insertKey2HashTable(3);
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }
}
// ```
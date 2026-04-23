package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_COC5Test {

    @Test
    public void testInsertKey2HashTable_TableNotFull_KeyNotPresent_NoRelocation() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(5);
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_TableFull_KeyNotPresent_Rehash() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(2));
        hashMap.insertKey2HashTable(3);
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_KeyAlreadyPresent_Exception() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_KeyRequiresRelocation_NoInfiniteLoop() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3); 
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    public void testInsertKey2HashTable_InfiniteLoop_Rehash() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(2);
        hashMap.insertKey2HashTable(3); 
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }
}
// ```
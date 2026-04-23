package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_ZS1Test {

    @Test
    public void testInsertKey2HashTable_NullTable() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(10);
        hashMapCuckooHashing.insertKey2HashTable(5);
        assertFalse(hashMapCuckooHashing.isEmpty());
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(10);
        hashMapCuckooHashing.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMapCuckooHashing.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_FullTable() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(1);
        hashMapCuckooHashing.insertKey2HashTable(5);
        assertTrue(hashMapCuckooHashing.getNumberOfKeysInTable() == 1);
    }

    @Test
    public void testInsertKey2HashTable_MultipleInsertions() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(10);
        hashMapCuckooHashing.insertKey2HashTable(5);
        hashMapCuckooHashing.insertKey2HashTable(15);
        assertTrue(hashMapCuckooHashing.getNumberOfKeysInTable() == 2);
    }

    @Test
    public void testInsertKey2HashTable_Rehashing() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(1);
        hashMapCuckooHashing.insertKey2HashTable(5);
        hashMapCuckooHashing.insertKey2HashTable(15);
        assertTrue(hashMapCuckooHashing.getNumberOfKeysInTable() == 2);
    }

    @Test
    public void testInsertKey2HashTable_LoadFactorCheck() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(2);
        hashMapCuckooHashing.insertKey2HashTable(5);
        hashMapCuckooHashing.insertKey2HashTable(15);
        assertTrue(hashMapCuckooHashing.checkLoadFactor() <= 0.7);
    }
}
// ```
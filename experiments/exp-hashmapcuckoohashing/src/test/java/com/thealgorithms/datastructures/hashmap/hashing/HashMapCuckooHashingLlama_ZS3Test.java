package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_ZS3Test {

    @Test
    public void testInsertKey2HashTable_KeyNotPresent() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(10);
        hashMapCuckooHashing.insertKey2HashTable(5);
        assertTrue(hashMapCuckooHashing.checkTableContainsKey(5));
    }

    @Test
    public void testInsertKey2HashTable_KeyAlreadyPresent() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(10);
        hashMapCuckooHashing.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMapCuckooHashing.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_TableFull() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(1);
        hashMapCuckooHashing.insertKey2HashTable(5);
        assertDoesNotThrow(() -> hashMapCuckooHashing.insertKey2HashTable(7));
    }

    @Test
    public void testInsertKey2HashTable_InfiniteLoop() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(2);
        hashMapCuckooHashing.insertKey2HashTable(5);
        hashMapCuckooHashing.insertKey2HashTable(7);
        assertDoesNotThrow(() -> hashMapCuckooHashing.insertKey2HashTable(9));
    }

    @Test
    public void testInsertKey2HashTable_MultipleInsertions() {
        HashMapCuckooHashing hashMapCuckooHashing = new HashMapCuckooHashing(10);
        for (int i = 0; i < 10; i++) {
            hashMapCuckooHashing.insertKey2HashTable(i);
            assertTrue(hashMapCuckooHashing.checkTableContainsKey(i));
        }
    }
}
// ```
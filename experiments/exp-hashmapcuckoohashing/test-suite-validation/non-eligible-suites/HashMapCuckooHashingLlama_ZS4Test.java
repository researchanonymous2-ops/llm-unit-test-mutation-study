package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingLlama_ZS4Test {

    @Test
    public void testInsertKey2HashTable_NullTable() {
        assertThrows(NullPointerException.class, () -> new HashMapCuckooHashing(0).insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_DuplicateKey() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        hashMap.insertKey2HashTable(1);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_FullTable() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(1);
        hashMap.insertKey2HashTable(1);
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(2));
    }

    @Test
    public void testInsertKey2HashTable_InfiniteLoop() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(2);
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(3);
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(5));
    }

    @Test
    public void testInsertKey2HashTable_SingleElement() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(1));
    }

    @Test
    public void testInsertKey2HashTable_MultipleElements() {
        HashMapCuckooHashing hashMap = new HashMapCuckooHashing(10);
        assertDoesNotThrow(() -> {
            hashMap.insertKey2HashTable(1);
            hashMap.insertKey2HashTable(2);
            hashMap.insertKey2HashTable(3);
        });
    }
}
// ```
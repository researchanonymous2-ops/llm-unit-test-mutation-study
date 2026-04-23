package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_COC1Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(16);
    }

    @Test
    void testInsertKey2HashTable_InsertIntoEmptyTable() {
        hashMap.insertKey2HashTable(42);
        assertTrue(hashMap.checkTableContainsKey(42));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_InsertDuplicateKey() {
        hashMap.insertKey2HashTable(42);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(42));
    }

    @Test
    void testInsertKey2HashTable_InsertMultipleKeys() {
        hashMap.insertKey2HashTable(10);
        hashMap.insertKey2HashTable(20);
        hashMap.insertKey2HashTable(30);
        assertTrue(hashMap.checkTableContainsKey(10));
        assertTrue(hashMap.checkTableContainsKey(20));
        assertTrue(hashMap.checkTableContainsKey(30));
        assertEquals(3, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_TriggerRehashOnFullTable() {
        // Preenche a tabela até o limite que força rehash
        for (int i = 0; i < 12; i++) { // 12 inserções em uma tabela de 16 posições com fator de carga 0.7
            hashMap.insertKey2HashTable(i * 10);
        }
        // A próxima inserção deve acionar o rehash
        hashMap.insertKey2HashTable(999);
        assertTrue(hashMap.checkTableContainsKey(999));
    }

    @Test
    void testInsertKey2HashTable_InsertWithCuckooDisplacement() {
        // Força deslocamentos cuckoo criando colisões controladas
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(17); // Provavelmente colidirá com 1 devido a hashFunction1
        assertTrue(hashMap.checkTableContainsKey(1));
        assertTrue(hashMap.checkTableContainsKey(17));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }
}
// ```
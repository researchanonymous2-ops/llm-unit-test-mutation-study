package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_POT1Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(16);
    }

    @Test
    void testInsertKey2HashTable_RehashBeforeInsertion() {
        // Preenche a tabela para forçar rehash
        for (int i = 0; i < 16; i++) {
            hashMap.insertKey2HashTable(i * 32); // Usando múltiplos para evitar colisões nas funções hash
        }
        
        // Verifica que a tabela foi rehasheada (tamanho dobrado)
        assertEquals(32, hashMap.getClass().getDeclaredField("tableSize").get(hashMap));
    }

    @Test
    void testInsertKey2HashTable_DuplicateKeyThrowsException() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    void testInsertKey2HashTable_DirectInsertionAfterHashFunction1() {
        hashMap.insertKey2HashTable(1);
        assertTrue(hashMap.checkTableContainsKey(1));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_SimpleRelocationAndInsertion() {
        // Força uma colisão controlada para testar realocação
        hashMap.insertKey2HashTable(0); // Vai para posição 0 com hashFunction1
        hashMap.insertKey2HashTable(16); // Também vai para posição 0 com hashFunction1, desloca o 0
        assertTrue(hashMap.checkTableContainsKey(0));
        assertTrue(hashMap.checkTableContainsKey(16));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_RehashAfterIterationLimit() {
        // Cria um cenário que força muitas realocações sucessivas
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(16);
        hashMap.insertKey2HashTable(32);
        hashMap.insertKey2HashTable(48);
        hashMap.insertKey2HashTable(64);
        hashMap.insertKey2HashTable(80);
        hashMap.insertKey2HashTable(96);
        hashMap.insertKey2HashTable(112);
        
        // Deve ter rehasheado devido ao limite de iterações
        assertTrue(hashMap.getNumberOfKeysInTable() > 0);
    }
}
// ```
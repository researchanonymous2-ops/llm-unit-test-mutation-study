package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_POT3Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    void testInsertKey2HashTable_T0_TableFull_RehashingOccurs() {
        // Preenche toda a tabela para forçar rehash
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i * 10);
        }
        
        // Verifica que a tabela está cheia
        assertTrue(hashMap.isFull());
        
        // Tenta inserir mais uma chave - deve causar rehash
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(999));
        
        // Verifica que a nova chave foi inserida após o rehash
        assertTrue(hashMap.checkTableContainsKey(999));
    }

    @Test
    void testInsertKey2HashTable_T1_DuplicateKey_IllegalArgumentException() {
        hashMap.insertKey2HashTable(42);
        
        // Tenta inserir a mesma chave novamente
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(42));
    }

    @Test
    void testInsertKey2HashTable_T2_DirectInsertion_FirstHashFunction() {
        int key = 5;
        int expectedHash = hashMap.hashFunction1(key);
        
        // Verifica que a posição está vazia inicialmente
        assertNull(hashMap.buckets[expectedHash]);
        
        hashMap.insertKey2HashTable(key);
        
        // Verifica que a chave foi inserida corretamente
        assertEquals(Integer.valueOf(key), hashMap.buckets[expectedHash]);
        assertTrue(hashMap.checkTableContainsKey(key));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_T3_SimpleRelocation_InsertionSecondHash() {
        // Força uma colisão no primeiro hash para testar realocação simples
        int key1 = 1; // Supondo que hashFunction1(1) = 1
        int key2 = 11; // Supondo que hashFunction1(11) = 1 (colisão)
        
        hashMap.insertKey2HashTable(key1); // Insere primeiro
        hashMap.insertKey2HashTable(key2); // Deve realocar usando hashFunction2
        
        // Verifica que ambas as chaves estão presentes
        assertTrue(hashMap.checkTableContainsKey(key1));
        assertTrue(hashMap.checkTableContainsKey(key2));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_T4_InfiniteLoop_RehashingAfterThreshold() {
        // Cria um cenário que força múltiplas realocações até atingir o limite
        // Usando uma tabela menor para facilitar o teste
        HashMapCuckooHashing smallMap = new HashMapCuckooHashing(4);
        
        // Insere chaves que causem muitas colisões
        smallMap.insertKey2HashTable(0);
        smallMap.insertKey2HashTable(4);
        smallMap.insertKey2HashTable(8);
        smallMap.insertKey2HashTable(12);
        
        // Verifica que a tabela foi refeita após múltiplas tentativas
        assertDoesNotThrow(() -> smallMap.insertKey2HashTable(1));
        assertTrue(smallMap.checkTableContainsKey(1));
    }
}
// ```
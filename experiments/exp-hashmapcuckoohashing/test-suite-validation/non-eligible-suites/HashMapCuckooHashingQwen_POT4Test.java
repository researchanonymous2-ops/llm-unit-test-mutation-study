package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_POT4Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    void testInsertKey2HashTable_T0_RehashBeforeInsertion() {
        // Preenche a tabela para forçar rehash
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i);
        }
        
        // Verifica que a tabela está cheia
        assertTrue(hashMap.isFull());
        
        // Tenta inserir uma nova chave - deve causar rehash
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(100));
        assertEquals(11, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_T1_DuplicateKeyDetection() {
        hashMap.insertKey2HashTable(5);
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(5));
    }

    @Test
    void testInsertKey2HashTable_T2_DirectInsertionAfterHashFunction1() {
        // Insere uma chave que vai para posição vazia no primeiro hash
        hashMap.insertKey2HashTable(7);
        assertEquals(1, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(7));
    }

    @Test
    void testInsertKey2HashTable_T3_SimpleRelocationAndInsertion() {
        // Configura situação onde ocorre realocação simples
        hashMap.insertKey2HashTable(1);
        hashMap.insertKey2HashTable(11); // Mesmo hash que 1 com tamanho 10
        
        // Ambas as chaves devem estar presentes após realocação
        assertEquals(2, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(1));
        assertTrue(hashMap.checkTableContainsKey(11));
    }

    @Test
    void testInsertKey2HashTable_T4_RelocationUntilIterationLimit() {
        // Cria cenário que força múltiplas realocações até o limite
        hashMap = new HashMapCuckooHashing(4); // Tamanho menor para facilitar o teste
        
        // Insere chaves que causam conflitos
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(4);
        hashMap.insertKey2HashTable(8);
        hashMap.insertKey2HashTable(12);
        
        // Deve conseguir inserir todas mesmo com múltiplas realocações
        assertEquals(4, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(0));
        assertTrue(hashMap.checkTableContainsKey(4));
        assertTrue(hashMap.checkTableContainsKey(8));
        assertTrue(hashMap.checkTableContainsKey(12));
    }
}
// ```
package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_POT2Test {

    private HashMapCuckooHashing hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapCuckooHashing(10);
    }

    @Test
    public void testInsertKey2HashTable_T0_RehashBeforeInsertion() {
        // Preenche a tabela para forçar rehash
        for (int i = 0; i < 10; i++) {
            hashMap.insertKey2HashTable(i * 10);
        }
        
        // Verifica que a tabela está cheia
        assertTrue(hashMap.isFull());
        
        // Tenta inserir mais uma chave - deve causar rehash antes da inserção
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(999));
    }

    @Test
    public void testInsertKey2HashTable_T1_DuplicateKeyException() {
        hashMap.insertKey2HashTable(42);
        
        // Tenta inserir a mesma chave novamente
        assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(42));
    }

    @Test
    public void testInsertKey2HashTable_T2_DirectInsertionFirstHash() {
        // Insere chave que vai para posição livre no primeiro hash
        hashMap.insertKey2HashTable(5);
        
        // Verifica que a chave foi inserida
        assertEquals(1, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(5));
    }

    @Test
    public void testInsertKey2HashTable_T3_SimpleRelocationAndInsertion() {
        // Configura situação onde ocorre realocação simples
        hashMap.insertKey2HashTable(0); // Vai para posição 0 com hash1
        hashMap.insertKey2HashTable(10); // Também vai para posição 0 com hash1, desloca o 0
        
        // Verifica que ambas as chaves foram inseridas
        assertEquals(2, hashMap.getNumberOfKeysInTable());
        assertTrue(hashMap.checkTableContainsKey(0));
        assertTrue(hashMap.checkTableContainsKey(10));
    }

    @Test
    public void testInsertKey2HashTable_T4_RehashAfterIterationLimit() {
        // Cria cenário que força múltiplas realocações até o limite
        hashMap = new HashMapCuckooHashing(4); // Tabela menor para facilitar o ciclo
        
        // Insere chaves que criam ciclo de deslocamentos
        hashMap.insertKey2HashTable(0);
        hashMap.insertKey2HashTable(4);
        hashMap.insertKey2HashTable(8);
        hashMap.insertKey2HashTable(12);
        
        // Verifica que todas foram inseridas após possíveis rehashes
        assertTrue(hashMap.getNumberOfKeysInTable() >= 3);
    }
}
// ```
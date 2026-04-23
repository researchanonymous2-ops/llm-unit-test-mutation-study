package com.thealgorithms.datastructures.hashmap.hashing;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingQwen_POT5Test {

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
        
        // Tenta inserir uma nova chave - deve forçar rehash
        assertDoesNotThrow(() -> hashMap.insertKey2HashTable(999));
        
        // Verifica que a nova chave foi inserida após rehash
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
        // Insere uma chave que vai para posição livre no primeiro hash
        hashMap.insertKey2HashTable(5);
        
        // Verifica que a chave foi inserida corretamente
        assertTrue(hashMap.checkTableContainsKey(5));
        assertEquals(1, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_T3_SimpleRelocation_SecondHashFunction() {
        // Configura cenário onde ocorre realocação simples
        hashMap.insertKey2HashTable(7);  // Vai para posição H1(7)
        hashMap.insertKey2HashTable(17); // Colide com 7, realoca 7 para H2(7), insere 17 em H1(17)
        
        // Verifica que ambas as chaves foram inseridas
        assertTrue(hashMap.checkTableContainsKey(7));
        assertTrue(hashMap.checkTableContainsKey(17));
        assertEquals(2, hashMap.getNumberOfKeysInTable());
    }

    @Test
    void testInsertKey2HashTable_T4_InfiniteLoop_RehashingAfterThreshold() {
        // Cria situação que força múltiplas realocações até atingir o limite
        // Usando tamanho pequeno para facilitar a ocorrência do cenário
        HashMapCuckooHashing smallMap = new HashMapCuckooHashing(4);
        
        // Insere chaves que causam múltiplas colisões
        smallMap.insertKey2HashTable(1);
        smallMap.insertKey2HashTable(5); // Provavelmente colidirá
        smallMap.insertKey2HashTable(9); // Provavelmente colidirá
        
        // A inserção deve funcionar mesmo em cenários complexos de colisão
        assertDoesNotThrow(() -> smallMap.insertKey2HashTable(13));
        
        // Verifica que a chave foi inserida
        assertTrue(smallMap.checkTableContainsKey(13));
    }
}
// ```
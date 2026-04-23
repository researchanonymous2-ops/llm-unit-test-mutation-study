package com.thealgorithms.datastructures.hashmap.hashing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_FS3Test {

   @Test
   void testInsertKey2HashTable_PositiveKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(15));
   }

   @Test
   void testInsertKey2HashTable_NegativeKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(-5));
   }

   @Test
   void testInsertKey2HashTable_ZeroKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(0));
   }

   @Test
   void testInsertKey2HashTable_LargeKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(1000000));
   }

   @Test
   void testInsertKey2HashTable_SequentialInsertions() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(1);
           map.insertKey2HashTable(2);
           map.insertKey2HashTable(3);
       });
   }

   @Test
   void testInsertKey2HashTable_DuplicateKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       map.insertKey2HashTable(20);
       assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(20));
   }

   @Test
   void testInsertKey2HashTable_CausesRehashByLoadFactor() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(1);
           map.insertKey2HashTable(2);
           map.insertKey2HashTable(3);
           map.insertKey2HashTable(4);
       });
   }
}

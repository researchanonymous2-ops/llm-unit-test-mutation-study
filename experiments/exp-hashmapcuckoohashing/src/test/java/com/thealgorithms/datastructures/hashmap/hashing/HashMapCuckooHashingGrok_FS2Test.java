package com.thealgorithms.datastructures.hashmap.hashing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_FS2Test {

   @Test
   void testInsertKey2HashTable_SingleInsertion() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(1));
   }

   @Test
   void testInsertKey2HashTable_MultipleInsertions() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(2);
           map.insertKey2HashTable(3);
           map.insertKey2HashTable(4);
       });
   }

   @Test
   void testInsertKey2HashTable_DuplicateKeyThrowsException() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       map.insertKey2HashTable(5);
       assertThrows(IllegalArgumentException.class,
           () -> map.insertKey2HashTable(5));
   }

   @Test
   void testInsertKey2HashTable_LoadFactorRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(6);
           map.insertKey2HashTable(7);
           map.insertKey2HashTable(8);
           map.insertKey2HashTable(9);
           map.insertKey2HashTable(10);
           map.insertKey2HashTable(11);
       });
   }

   @Test
   void testInsertKey2HashTable_InfiniteLoopRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(12);
           map.insertKey2HashTable(13);
           map.insertKey2HashTable(14);
           map.insertKey2HashTable(15);
       });
   }
}

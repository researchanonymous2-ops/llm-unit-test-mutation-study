package com.thealgorithms.datastructures.hashmap.hashing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_FS1Test {

   @Test
   void testInsertKey2HashTable_SingleInsertion() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(15));
   }

   @Test
   void testInsertKey2HashTable_MultipleInsertions() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(20);
           map.insertKey2HashTable(25);
           map.insertKey2HashTable(30);
       });
   }

   @Test
   void testInsertKey2HashTable_DuplicateKeyThrowsException() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       map.insertKey2HashTable(12);
       assertThrows(IllegalArgumentException.class,
           () -> map.insertKey2HashTable(12));
   }

   @Test
   void testInsertKey2HashTable_LoadFactorRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(1);
           map.insertKey2HashTable(2);
           map.insertKey2HashTable(3);
           map.insertKey2HashTable(4);
       });
   }

   @Test
   void testInsertKey2HashTable_FullTableRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(2);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(1);
           map.insertKey2HashTable(2);
           map.insertKey2HashTable(3);
       });
   }
}

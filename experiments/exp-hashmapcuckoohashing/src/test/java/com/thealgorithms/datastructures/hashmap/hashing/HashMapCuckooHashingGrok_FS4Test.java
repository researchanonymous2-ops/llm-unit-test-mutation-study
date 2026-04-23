package com.thealgorithms.datastructures.hashmap.hashing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_FS4Test {

   @Test
   void testInsertKey2HashTable_NewKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(15));
       assertTrue(map.checkTableContainsKey(15));
       assertEquals(1, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_SeveralKeys() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> {
           map.insertKey2HashTable(20);
           map.insertKey2HashTable(30);
           map.insertKey2HashTable(40);
       });
       assertTrue(map.checkTableContainsKey(20));
       assertTrue(map.checkTableContainsKey(30));
       assertTrue(map.checkTableContainsKey(40));
       assertEquals(3, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_DuplicateThrows() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       map.insertKey2HashTable(25);
       assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(25));
       assertEquals(1, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_LoadFactorTriggersRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       assertDoesNotThrow(() -> {
           for (int i = 1; i <= 4; i++) {
               map.insertKey2HashTable(i);
           }
       });
       assertEquals(4, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_ZeroKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(0));
       assertTrue(map.checkTableContainsKey(0));
       assertEquals(1, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_NegativeKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(8);
       assertDoesNotThrow(() -> map.insertKey2HashTable(-5));
       assertTrue(map.checkTableContainsKey(-5));
       assertEquals(1, map.getNumberOfKeysInTable());
   }
}

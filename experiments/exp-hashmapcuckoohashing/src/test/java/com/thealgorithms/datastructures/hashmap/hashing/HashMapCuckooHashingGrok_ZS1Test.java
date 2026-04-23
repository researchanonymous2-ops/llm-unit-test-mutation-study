package com.thealgorithms.datastructures.hashmap.hashing;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_ZS1Test {

   private HashMapCuckooHashing hashMap;

   @BeforeEach
   void setUp() {
       hashMap = new HashMapCuckooHashing(4);
   }

   @Test
   void testInsertKey2HashTable_InsertNewKey() {
       hashMap.insertKey2HashTable(1);
       assertTrue(hashMap.checkTableContainsKey(1));
       assertEquals(1, hashMap.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_InsertMultipleKeys() {
       hashMap.insertKey2HashTable(1);
       hashMap.insertKey2HashTable(2);
       hashMap.insertKey2HashTable(3);
       assertTrue(hashMap.checkTableContainsKey(1));
       assertTrue(hashMap.checkTableContainsKey(2));
       assertTrue(hashMap.checkTableContainsKey(3));
       assertEquals(3, hashMap.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_InsertDuplicateKey() {
       hashMap.insertKey2HashTable(1);
       assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
   }

   @Test
   void testInsertKey2HashTable_InsertWhenFull() {
       hashMap.insertKey2HashTable(0);
       hashMap.insertKey2HashTable(4);
       hashMap.insertKey2HashTable(8);
       hashMap.insertKey2HashTable(12);
       int initialSize = hashMap.getNumberOfKeysInTable();
       hashMap.insertKey2HashTable(16);
       assertTrue(hashMap.checkTableContainsKey(16));
       assertTrue(hashMap.getNumberOfKeysInTable() > initialSize);
   }

   @Test
   void testInsertKey2HashTable_LoadFactorRehash() {
       HashMapCuckooHashing smallHashMap = new HashMapCuckooHashing(2);
       smallHashMap.insertKey2HashTable(1);
       smallHashMap.insertKey2HashTable(2);
       assertTrue(smallHashMap.checkTableContainsKey(1));
       assertTrue(smallHashMap.checkTableContainsKey(2));
       assertTrue(smallHashMap.getNumberOfKeysInTable() >= 2);
   }

   @Test
   void testInsertKey2HashTable_InfiniteLoopRehash() {
       HashMapCuckooHashing smallHashMap = new HashMapCuckooHashing(2);
       smallHashMap.insertKey2HashTable(0);
       smallHashMap.insertKey2HashTable(1);
       smallHashMap.insertKey2HashTable(2);
       assertTrue(smallHashMap.checkTableContainsKey(2));
       assertTrue(smallHashMap.getNumberOfKeysInTable() >= 3);
   }
}

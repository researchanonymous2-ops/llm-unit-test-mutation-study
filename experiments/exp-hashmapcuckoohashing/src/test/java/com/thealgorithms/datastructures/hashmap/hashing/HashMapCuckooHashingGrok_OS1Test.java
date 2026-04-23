package com.thealgorithms.datastructures.hashmap.hashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.hashmap.hashing.HashMapCuckooHashing;

public class HashMapCuckooHashingGrok_OS1Test {

   @Test
   void testInsertKey2HashTable_SingleInsertion() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       map.insertKey2HashTable(5);
       assertTrue(map.checkTableContainsKey(5));
       assertEquals(1, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_MultipleInsertions() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       map.insertKey2HashTable(1);
       map.insertKey2HashTable(2);
       map.insertKey2HashTable(3);
       assertTrue(map.checkTableContainsKey(1));
       assertTrue(map.checkTableContainsKey(2));
       assertTrue(map.checkTableContainsKey(3));
       assertEquals(3, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_DuplicateKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       map.insertKey2HashTable(10);
       assertThrows(IllegalArgumentException.class, () -> map.insertKey2HashTable(10));
   }

   @Test
   void testInsertKey2HashTable_LoadFactorRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       map.insertKey2HashTable(1);
       map.insertKey2HashTable(2);
       map.insertKey2HashTable(3);
       map.insertKey2HashTable(4); // This should trigger rehash due to load factor
       assertTrue(map.checkTableContainsKey(1));
       assertTrue(map.checkTableContainsKey(2));
       assertTrue(map.checkTableContainsKey(3));
       assertTrue(map.checkTableContainsKey(4));
       assertEquals(4, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_InfiniteLoopRehash() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(2);
       map.insertKey2HashTable(0);
       map.insertKey2HashTable(2); // This might cause infinite loop and rehash
       assertTrue(map.checkTableContainsKey(0));
       assertTrue(map.checkTableContainsKey(2));
   }

   @Test
   void testInsertKey2HashTable_NegativeKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       map.insertKey2HashTable(-5);
       assertTrue(map.checkTableContainsKey(-5));
       assertEquals(1, map.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_ZeroKey() {
       HashMapCuckooHashing map = new HashMapCuckooHashing(4);
       map.insertKey2HashTable(0);
       assertTrue(map.checkTableContainsKey(0));
       assertEquals(1, map.getNumberOfKeysInTable());
   }
}

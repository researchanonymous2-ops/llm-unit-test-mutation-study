package com.thealgorithms.datastructures.hashmap.hashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingGrok_ZS4Test {

   private HashMapCuckooHashing hashMap;

   @BeforeEach
   void setUp() {
       hashMap = new HashMapCuckooHashing(4);
   }

   @Test
   void testInsertKey2HashTable_InsertSingleKey() {
       hashMap.insertKey2HashTable(1);
       assertEquals(1, hashMap.getNumberOfKeysInTable());
       assertTrue(hashMap.checkTableContainsKey(1));
   }

   @Test
   void testInsertKey2HashTable_InsertMultipleKeys() {
       hashMap.insertKey2HashTable(1);
       hashMap.insertKey2HashTable(2);
       hashMap.insertKey2HashTable(3);
       assertEquals(3, hashMap.getNumberOfKeysInTable());
       assertTrue(hashMap.checkTableContainsKey(1));
       assertTrue(hashMap.checkTableContainsKey(2));
       assertTrue(hashMap.checkTableContainsKey(3));
   }

   @Test
   void testInsertKey2HashTable_InsertDuplicateKey() {
       hashMap.insertKey2HashTable(1);
       assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
   }

   @Test
   void testInsertKey2HashTable_RehashOnLoadFactor() {
       HashMapCuckooHashing smallMap = new HashMapCuckooHashing(2);
       smallMap.insertKey2HashTable(1);
       smallMap.insertKey2HashTable(2);
       // Load factor should trigger rehash on next insert if >0.7, but with size 2, after 2 inserts, factor=1.0, but checkLoadFactor is called after insert
       // Actually, after inserting 2 in size 2, size=2, factor=1.0, but checkLoadFactor checks >0.7, so rehash on next if applicable
       // To trigger, insert more
       smallMap.insertKey2HashTable(3);
       assertTrue(smallMap.getNumberOfKeysInTable() >= 3);
       assertTrue(smallMap.checkTableContainsKey(3));
   }

   @Test
   void testInsertKey2HashTable_RehashOnFull() {
       HashMapCuckooHashing smallMap = new HashMapCuckooHashing(2);
       smallMap.insertKey2HashTable(1);
       smallMap.insertKey2HashTable(2);
       // Now full, next insert should rehash
       smallMap.insertKey2HashTable(3);
       assertTrue(smallMap.getNumberOfKeysInTable() >= 3);
       assertTrue(smallMap.checkTableContainsKey(3));
   }
}

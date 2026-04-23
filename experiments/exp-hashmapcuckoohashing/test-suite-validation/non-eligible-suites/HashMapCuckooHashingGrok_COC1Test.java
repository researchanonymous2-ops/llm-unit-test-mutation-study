package com.thealgorithms.datastructures.hashmap.hashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapCuckooHashingGrok_COC1Test {

   private HashMapCuckooHashing hashMap;

   @BeforeEach
   void setUp() {
       hashMap = new HashMapCuckooHashing(4);
   }

   @Test
   void testInsertKey2HashTable_FullTable() {
       // Fill the table
       hashMap.insertKey2HashTable(1);
       hashMap.insertKey2HashTable(2);
       hashMap.insertKey2HashTable(3);
       hashMap.insertKey2HashTable(4);
       int originalSize = hashMap.tableSize;
       // Insert another key, should trigger rehash
       hashMap.insertKey2HashTable(5);
       assertTrue(hashMap.tableSize > originalSize);
       assertTrue(hashMap.checkTableContainsKey(5));
   }

   @Test
   void testInsertKey2HashTable_DuplicateKey() {
       hashMap.insertKey2HashTable(1);
       assertThrows(IllegalArgumentException.class, () -> hashMap.insertKey2HashTable(1));
   }

   @Test
   void testInsertKey2HashTable_SimpleInsert() {
       hashMap.insertKey2HashTable(1);
       assertTrue(hashMap.checkTableContainsKey(1));
       assertEquals(1, hashMap.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_InsertWithRelocation() {
       // Insert keys to force relocation
       hashMap.insertKey2HashTable(0);
       hashMap.insertKey2HashTable(4); // Assuming hash2 of 0 is 0, but let's use keys that collide
       // To force relocation, insert a key that takes the place of another
       // hashFunction1(0) = 0, hashFunction2(0) = 0
       // Insert 0, then insert 4, hash1(4)=0, so relocation
       hashMap.insertKey2HashTable(4);
       assertTrue(hashMap.checkTableContainsKey(4));
       assertEquals(2, hashMap.getNumberOfKeysInTable());
   }

   @Test
   void testInsertKey2HashTable_InfiniteLoop() {
       // Set small thresh to force rehash
       hashMap.thresh = 1;
       // Insert keys that might cause loop
       hashMap.insertKey2HashTable(0);
       hashMap.insertKey2HashTable(4);
       hashMap.insertKey2HashTable(8); // This might trigger rehash due to loop
       assertTrue(hashMap.checkTableContainsKey(8));
   }
}

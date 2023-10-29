package com.meena.lru_cache;


import java.util.HashMap;
/*
LRU Cache :  https://www.youtube.com/watch?v=akFRa58Svug
*/


/*
  So In java if I want to make a generic Implementation of Some Data Structure (in this case LRU Cache) where the
  internal data structure is a HashMap (hashset, or basically something which uses hash mechanism)
  for producing correct reusult I should only support classes which implements the Equals and HashCOde methods
  OR
  Somehow enforce the implementation of them if they need to use my DataStructure..

  so if you think the idea behind equals and hashcode is to make sure that the object is unique and the equality can be verified

 */
public class LRUCache<K extends EqualsAndHashCode, V> {

  private final int capacity;
  private HashMap<K, V> map;
  private ModifiedDoublyLinkedList<V> dll;


  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.dll = new ModifiedDoublyLinkedList<>();
  }

  //  public V get(K key) {
  //
  //  }

  //  public V remove(K key){
  //
  //  }

  //  public boolean add(K key, V value){
  //
  //  }
}

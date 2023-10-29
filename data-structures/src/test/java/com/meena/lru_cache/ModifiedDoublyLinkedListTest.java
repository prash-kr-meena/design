package com.meena.lru_cache;

import org.junit.jupiter.api.Test;

class ModifiedDoublyLinkedListTest {

  //  ModifiedDoublyLinkedList<Integer> dll;
  ModifiedDoublyLinkedList<Integer> dll = new ModifiedDoublyLinkedList<>();

  //  @BeforeAll
  //  void setup() {
  //
  //  }


  @Test
  void addToHead() {
    dll.addToHead(1);
    dll.addToHead(3);
    dll.addToHead(5);
    dll.addToHead(8);
    dll.print();
  }


  @Test
  void addToTail() {
  }


  @Test
  void removeFromHead() {
  }


  @Test
  void removeFromTail() {
  }


  @Test
  void remove() {
  }


}
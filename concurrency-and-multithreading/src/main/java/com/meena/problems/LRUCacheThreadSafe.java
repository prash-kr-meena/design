//package com.meena.problems;
//
//import java.util.HashMap;
//
//
///*
// all get, put and remove needs to be O(1)
//*/
//class Node {
//
//  Node left;
//  Node right;
//  int value;
//  String key;
//
//
//  Node(int kay, int value) {
//    left = null;
//    right = null;
//    this.key = key;
//    this.value = value;
//  }
//
//}
//
//class MyLinkedList {
//
//  Node head;
//  Node tail;
//
//
//  Node add(int value) { // this will be O(1)
//    // creat neo dand addd
//    Node node = new Node(value);
//
//  }
//
//
//  Node updateRecency(Node node) { // append it at the end / start
//    //
//  }
//
//
//  boolean remove(Node node) { // remove it
//    //
//  }
//
//  linkedList.removeOldest()
//
//
//  {
//    // will remove the nodef from head / tail
//    // but we woul need the key to remove it form the Node
//    // and get the key form the node, and remove it form the map as well
//  }
//
//}
//
//
//class LRUCache {
//
//  HashMap<String, Node> map;
//  MyLinkedList linkedList;
//
//
//  LRUCache(int capacity) {
//    HashMap<String, Node> map = new HashMap<>();
//    MyLinkedList linkedList = new MyLinkedList();
//  }
//
//
//  int get(String key) {
//    Node node = map.get(key);
//    if (isNull(node)) {
//      return -1;
//    }
//    linkedList.updateRecency(node);
//    return node.key;
//  }
//
//
//  put(String key, int value) {
//    if (linkedList.size() == capaity) {
//      linkedList.removeOldest();
//    }
//    Node node = linkedList.add(value);
//    map.put(key, node);
//  }
//
//
//  boolean remove(String key) {
//    Node node = map.get(key);
//    if (isNull(node)) {
//      return false;
//    }
//    map.remove(key);
//    linkedList.remove(node);
//  }
//
//}
//
//
//class Solution {
//
//  public static void main(String[] args) {
//
//    LruCache cache = new LRUCache(4);
//    cache.put("a", 1);
//    cache.put("b", 1);
//    cache.put("c", 1);
//    cache.get("a", 1);
//    cache.get("c", 1);
//    cache.remove("d", 1);
//
//  }
//
//}
//
//
///*
//LRU cache
//- get(key)
//- put(key, value)
//
//a -> 1
//b -> 2
//c -> 3
//d -> 4
//
//[ a , b , c ]
//
//
//
//a -> 1
//c -> 3
//c <-
//d -> 4
//[a , c , ]
//
//*/
//
//// Your previous Plain Text content is preserved below:
//
//// Pad for Prashant Kumar Meena - Software Engineer - NAS CD
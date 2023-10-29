package com.meena.lru_cache;

import lombok.Getter;
import lombok.Setter;

// Package Private Class, I don't want anyone to use this class outside of this package
// The reason we are saying it is a Modified DLL, is because we are exposing the Node object as outputs of the methods
// Which would not be the case generally, but in our case as we are using it for the LRU cache, we need to expose the Node
// so that the map of LRU cache can store the reference of it, and use it to remove the node from the DLL in O(1)
class ModifiedDoublyLinkedList<T> {

  private Node<T> head;
  private Node<T> tail;


  public ModifiedDoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }


  @Getter
  @Setter
  // No requirement of comparing the Nodes, so equals() is Not required
  // LinkedList does not use has internally so no hashcode() method is required
  private static class Node<T> {

    private Node<T> left;
    private Node<T> right;
    private T data;


    public Node(T data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

  }


  void print() {
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.right;
    }
    System.out.println("null");
  }


  boolean remove(Node<T> node) {
    if (node == null) {
      return false;
    }
    // break the left and right connection of node
    // and connect the left and right node together if they exist
    // cases:        NULL <-> [a] <-> [b] <->  [b] <-> NULL     Deleting a, b, or c  will require different handling

    Node<T> leftNode = node.left;
    Node<T> rightNode = node.right;

    if (leftNode == null && rightNode == null) {
      // Only one element in the list, which is to be deleted
      head = tail = null;
      return true;
    }

    if (leftNode == null) {
      return removeFromHead();
    }
    if (rightNode == null) {
      return removeFromTail();
    }

    // removal from somewhere in the middle, It does not change head or tail
    // connecting the leftNode directly to rightNode
    leftNode.right = rightNode;
    rightNode.left = leftNode;
    node.left = null;
    node.right = null;
    return true;
  }


  boolean removeFromHead() {
    Node<T> node = head;
    head = node.right;
    node.right = null;
    head.left = null;
    return true;
  }


  boolean removeFromTail() {
    Node<T> node = tail;
    tail = node.left;
    node.left = null;
    tail.right = null;
    return true;
  }


  Node<T> addToHead(T data) {
    Node<T> node = new Node<>(data);
    // If first element
    // Both head and tail should be null together, otherwise if only one of them is null it will be an Illegal State
    if (head == null && tail == null) {
      head = tail = node;
      return node;
    }
    // Adding to head
    node.right = head;  // making right connection
    head.left = node;   // making left connection
    head = node;
    return node;
  }


  Node<T> addToTail(T data) {
    Node<T> node = new Node<>(data);
    // If first element
    // Both head and tail should be null together, otherwise if only one of them is null it will be an Illegal State
    if (head == null && tail == null) {
      head = tail = node;
      return node;
    }
    // Adding to tail
    tail.right = node;
    node.left = tail;
    tail = node;
    return node;
  }


}

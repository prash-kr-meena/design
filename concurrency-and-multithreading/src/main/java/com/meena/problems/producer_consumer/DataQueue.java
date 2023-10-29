package com.meena.problems.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {

  private final Queue<Message> queue = new LinkedList<>();
  private final int maxSize;
  private final Object IS_NOT_FULL = new Object();
  private final Object IS_NOT_EMPTY = new Object();


  DataQueue(int maxSize) {
    this.maxSize = maxSize;
  }


  public void waitIsNotFull() throws InterruptedException {
    synchronized (IS_NOT_FULL) {
      IS_NOT_FULL.wait();
    }
  }


  private void notifyIsNotFull() {
    synchronized (IS_NOT_FULL) {
      IS_NOT_FULL.notify();
    }
  }


  public void waitIsNotEmpty() throws InterruptedException {
    synchronized (IS_NOT_EMPTY) {
      IS_NOT_EMPTY.wait();
    }
  }


  public void notifyIsNotEmpty() {
    synchronized (IS_NOT_EMPTY) {
      IS_NOT_EMPTY.notify();
    }
  }


  public void add(Message message) {
    queue.add(message);
    notifyIsNotEmpty();
  }


  public Message remove() {
    Message mess = queue.poll();
    notifyIsNotFull();
    return mess;
  }


  public boolean isFull() {
    return queue.size() == maxSize;
  }

}

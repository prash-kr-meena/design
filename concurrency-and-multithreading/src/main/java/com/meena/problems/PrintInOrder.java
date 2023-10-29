package com.meena.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

  public static void main(String[] args) {
    Runnable printFirst = () -> System.out.println("first");
    Runnable printSecond = () -> System.out.println("second");
    Runnable printThird = () -> System.out.println("third");

    Thread thread1 = new Thread(printFirst);
    Thread thread2 = new Thread(printSecond);
    Thread thread3 = new Thread(printThird);

    thread3.start();
    thread1.start();
    thread2.start();

  }

}

class Foo {

  private volatile int count;
  private final Lock lock;
  private final Condition firstCalled;
  private final Condition secondCalled;


  public Foo() {
    count = 0;
    lock = new ReentrantLock();
    firstCalled = lock.newCondition();
    secondCalled = lock.newCondition();
  }


  public void first(Runnable printFirst) throws InterruptedException {
    lock.lock();
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    count = 1;
    firstCalled.signal();
    lock.unlock();
  }


  public void second(Runnable printSecond) throws InterruptedException {
    lock.lock();
    while (count < 1) {
      firstCalled.await();
    }
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    count = 2;
    secondCalled.signal();
    lock.unlock();
  }


  public void third(Runnable printThird) throws InterruptedException {
    lock.lock();
    while (count < 2) {
      secondCalled.await();
    }
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
    count = 3;
    lock.unlock();
  }

}
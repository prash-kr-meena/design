package com.meena.threads;

import com.meena.ThreadUtil;

public class StoppingAThreadWithException {

  /*
   A thread can stop itself by calling the static method Thread.interrupted().
   The interrupted() method will cause the thread to throw an InterruptedException.
   The InterruptedException is a checked exception, so it must be caught or declared to be thrown.
   */


  public static void main(String[] args) {
    threadCanBeInterrupted();
    threadCanNotBeInterrupted();
  }


  /*
    If this thread is blocked in an invocation of
      - the wait(), wait(long), or wait(long, int) methods of the Object class, or
      - of the join(), join(long), join(long, int), sleep(long), or sleep(long, int) methods of this class,
    then its interrupt status will be cleared, and it will receive an InterruptedException.
  */
  private static void threadCanBeInterrupted() {
    Thread thread = new Thread(() -> {
      System.out.println("Thread: " + Thread.currentThread().getName() + " STARTED");
      while (true) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " running!");
        ThreadUtil.sleep(1000);
      }
    });
    thread.start();
    ThreadUtil.sleep(5000);
    System.out.println("Main thread interrupting thread");
    thread.interrupt();
    System.out.println("Main thread interrupting thread - DONE");
  }


  private static void threadCanNotBeInterrupted() {
    Thread thread = new Thread(() -> {
      System.out.println("Thread: " + Thread.currentThread().getName() + " STARTED");
      while (true) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " running!");
        // ThreadUtil.sleep(1000);                  <<  Note
      }
    });
    thread.start();
    // ThreadUtil.sleep(5000);                      <<  Note
    System.out.println("Main thread interrupting thread");
    thread.interrupt();
    System.out.println("Main thread interrupting thread - DONE");
  }

}

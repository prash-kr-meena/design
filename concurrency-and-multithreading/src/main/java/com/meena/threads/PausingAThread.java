package com.meena.threads;

import com.meena.ThreadUtil;

public class PausingAThread {

  public static void main(String[] args) {
    /*
      A thread can pause itself by calling the static method Thread.sleep().
      The sleep() takes a number of milliseconds as parameter.
      The sleep() method will attempt to sleep that number of milliseconds before resuming execution.
      The Thread sleep() is not 100% precise, but it is pretty good still.
    */
    Thread thread = new Thread(() -> {
      System.out.println("Thread: " + Thread.currentThread().getName() + " running");
      System.out.println("Thread: " + Thread.currentThread().getName() + " pausing");
      ThreadUtil.sleep(3000);
      System.out.println("Thread: " + Thread.currentThread().getName() + " completed");
    });
    thread.start();

  }


}

package com.meena.threads;

import com.meena.ThreadUtils;

/*
  Stop a Thread
  Stopping a Java Thread requires some preparation of your thread implementation code.
  The Java Thread class contains a stop() method, but it is deprecated.
  The original stop() method would not provide any guarantees about in what state the thread was stopped.
  That means, that all Java objects the thread had access to during execution would be left in an unknown state.
  If other threads in your application also has access to the same objects, your application could fail unexpectedly and unpredictably.
*/
public class StoppingAThread {

  /*
    Instead of calling the stop() method you will have to implement your thread code, so it can be stopped.
    Here is an example of a class that implements Runnable which contains an extra method called doStop() which signals to the Runnable to stop.
    The Runnable will check this signal and stop when it is ready to do so.
  */


  public static void main(String[] args) {
    MyStopableRunnable myStopableRunnable = new MyStopableRunnable();
    Thread thread = new Thread(myStopableRunnable);
    thread.start();

    ThreadUtils.sleep(5000);
    myStopableRunnable.doStop();
  }

}

/*
  Please keep in mind that if your Runnable implementation needs more than just the run() method
  (e.g. a stop() or pause() method too), then you can no longer create your Runnable implementation with a Java lambda expression.
  A Java lambda can only implement a single method.
  Instead, you must use a custom class, or a custom interface that extends Runnable which has the extra methods, and which is implemented by an anonymous class.
*/
class MyStopableRunnable implements Runnable {

  private boolean doStop = false;


  public synchronized void doStop() {
    this.doStop = true;
  }


  private synchronized boolean isStopped() {
    return this.doStop;
  }


  @Override
  public void run() {
    System.out.println("Thread: " + Thread.currentThread().getName() + " STARTED");
    while (!isStopped()) {
      System.out.println("Thread: " + Thread.currentThread().getName() + " running!");
      ThreadUtils.sleep(1000);
    }
    System.out.println("Thread: " + Thread.currentThread().getName() + " STOPPED");
  }

}

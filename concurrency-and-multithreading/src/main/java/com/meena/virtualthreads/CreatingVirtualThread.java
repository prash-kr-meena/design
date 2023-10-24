package com.meena.virtualthreads;

import java.util.stream.IntStream;

/*
  https://jenkov.com/tutorials/java-concurrency/java-virtual-threads.html

  Java virtual threads are a new thread construct added to Java from Java 19.
  Java virtual threads are different from the original platform threads in that virtual threads are much more lightweight
  in terms of how many resources (RAM) they demand from the system to run.
  Thus, you can have far more virtual threads running in your applications than platform threads.

  With more virtual threads running you can do more blocking IO in parallel than with fewer platform threads.
  This is useful if your application needs to make many parallel network calls to external services such as REST APIs,
  or open many connections to external databases (via JDBC) or similar.
*/
public class CreatingVirtualThread {

  public static void main(String[] args) throws InterruptedException {
    createPlatformThread();
    //    createPlatformThreadViaFactory();
    //    createVirtualThread();

  }


  private static void createPlatformThread() {
    Runnable runnable = () -> IntStream.rangeClosed(0, 5)
      .forEach((i) -> System.out.println(i + " " + Thread.currentThread().getName()));
    Thread thread = new Thread(runnable);
    thread.start();       // Note: No need to join here
    System.out.println("Is Daemon : " + thread.isDaemon());
    System.out.println("Is Virtual : " + thread.isVirtual());
  }


  //  To create a new virtual thread in Java,
  //  you use the new Thread.ofVirtual() factory method, passing an implementation of the Runnable interface.
  private static void createVirtualThread() throws InterruptedException {
    Runnable runnable = () -> IntStream.rangeClosed(0, 5)
      .forEach((i) -> System.out.println(i + " " + Thread.currentThread().getName()));

    Thread vThread = Thread.ofVirtual().start(runnable);  // Creating and Starting at the same time

    System.out.println("Is Daemon : " + vThread.isDaemon());
    System.out.println("Is Virtual : " + vThread.isVirtual());
    vThread.join(); // If you don't join it, JVM will not wait for them to finish.
    // They behave like the daemon threads, as in case of platform thread even if the main thread is finished
    // the JVM will still be running for the other platform threads to finish.
  }


}

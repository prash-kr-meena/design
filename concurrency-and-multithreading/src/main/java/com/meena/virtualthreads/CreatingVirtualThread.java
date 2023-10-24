package com.meena.virtualthreads;

import com.meena.ConsoleUtils;
import java.util.stream.IntStream;
import lombok.SneakyThrows;

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

  public static void main(String[] args) {
    Runnable runnable = () -> IntStream.rangeClosed(0, 5)
      .forEach((i) -> System.out.println(i + " " + Thread.currentThread().getName()));

    createPlatformThread(runnable);
    ConsoleUtils.horizontalLine();
    createPlatformThreadViaFactory(runnable);
    ConsoleUtils.horizontalLine();
    createVirtualThreadWhichStartsImmediately(runnable);
    ConsoleUtils.horizontalLine();
    createVirtualThreadWhichDoesNotStartsImmediately(runnable);

  }


  @SneakyThrows
  private static void createPlatformThread(Runnable runnable) {
    Thread thread = new Thread(runnable);
    thread.start();       // Note: No need to join here
    System.out.println("Is Daemon : " + thread.isDaemon());
    System.out.println("Is Virtual : " + thread.isVirtual());

    thread.join();  // I am adding join later on here, because I want to end this method here
    // so that the thread in this does not interfere in the subsequence methods which I am calling in the main method.
    // But for running this thread, join is not important, as these are not daemon threads.
  }


  @SneakyThrows
  private static void createPlatformThreadViaFactory(Runnable runnable) {
    Thread pThread = Thread.ofPlatform().start(runnable);// Creating and Starting at the same time
    System.out.println("Is Daemon : " + pThread.isDaemon());
    System.out.println("Is Virtual : " + pThread.isVirtual());

    pThread.join();  // I am adding join later on here, because I want to end this method here
    // so that the thread in this does not interfere in the subsequence methods which I am calling in the main method.
    // But for running this thread, join is not important, as these are not daemon threads.

  }


  //  To create a new virtual thread in Java,
  //  you use the new Thread.ofVirtual() factory method, passing an implementation of the Runnable interface.
  @SneakyThrows
  private static void createVirtualThreadWhichStartsImmediately(Runnable runnable) {
    Thread vThread = Thread.ofVirtual().name("vThread").start(runnable);  // Creating and Starting at the same time

    System.out.println("Is Daemon : " + vThread.isDaemon());
    System.out.println("Is Virtual : " + vThread.isVirtual());

    // You can join a virtual thread just like a platform thread - which means waiting until the virtual thread
    // has finished its work and stopped executing.

    vThread.join(); // If you don't join it, JVM will not wait for them to finish.
    // They behave like the daemon threads, as in case of platform thread even if the main thread is finished
    // the JVM will still be running for the other platform threads to finish.

  }


  @SneakyThrows
  private static void createVirtualThreadWhichDoesNotStartsImmediately(Runnable runnable) {
    Thread vThread = Thread.ofVirtual().name("vThread").unstarted(runnable);// Creating the thread, but not Starting it
    vThread.start();

    vThread.join(); // If you don't join it, JVM will not wait for them to finish.
    // They behave like the daemon threads, as in case of platform thread even if the main thread is finished
    // the JVM will still be running for the other platform threads to finish.
  }

}

package com.meena.problems.producer_consumer;

public class Producer implements Runnable {

  private final DataQueue dataQueue;
  private boolean running = false;


  public Producer(DataQueue dataQueue) {
    this.dataQueue = dataQueue;
  }


  @Override
  public void run() {
    running = true;
    produce();
  }


  public void produce() {
    while (running) {
      if (dataQueue.isFull()) {
        try {
          dataQueue.waitIsNotFull();
        } catch (InterruptedException e) {
          System.out.println("Error while waiting to Produce messages.");
          break;
        }
      }
      if (!running) {
        break;
      }
      dataQueue.add(generateMessage());
    }
    System.out.println("Producer Stopped");
  }


  public void stop() {
    running = false;
    dataQueue.notifyIsNotFull();
  }

  // Other methods
}

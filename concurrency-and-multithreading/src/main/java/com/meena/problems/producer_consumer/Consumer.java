package com.meena.problems.producer_consumer;

public class Consumer implements Runnable {

  private final DataQueue dataQueue;
  private boolean running = false;


  public Consumer(DataQueue dataQueue) {
    this.dataQueue = dataQueue;
  }


  @Override
  public void run() {
    consume();
  }


  public void consume() {
    while (running) {
      if (dataQueue.isEmpty()) {
        try {
          dataQueue.waitIsNotEmpty();
        } catch (InterruptedException e) {
          log.severe("Error while waiting to Consume messages.");
          break;
        }
      }
      if (!running) {
        break;
      }
      Message message = dataQueue.poll();
      useMessage(message);
    }
    log.info("Consumer Stopped");
  }


  public void stop() {
    running = false;
    dataQueue.notifyIsNotEmpty();
  }

}

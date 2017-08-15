package examples;

import io.vertx.core.Vertx;

public class TimerExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    // Netty 定时任务的实现：
    // EventLoop中维护了scheduledTaskQueue，线程在loop的过程中，会从这个queue中过滤已经到时的任务并放到taskQueue中。
    // taskQueue是EventLoop的消费队列。
    vertx.setTimer(1000, l -> {
      System.out.println("...");
    });
  }
}

package examples;

import io.vertx.core.Vertx;

public class BlockingExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    // 执行一个阻塞任务需要提供两个Handler：其中一个Handler需要提供Result Future，另一个Handler需要处理Result。
    // 其中阻塞代码会丢到固定的线程池中执行。
    vertx.executeBlocking(future -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        future.fail(e);
      }

      System.out.println("after a time cost");

      future.complete();
    }, true, rs -> {
      if (rs.succeeded()) {
        System.out.println("succeed");
      } else {
        System.out.println("failed");
      }
    });
  }
}

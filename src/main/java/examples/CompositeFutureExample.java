package examples;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class CompositeFutureExample {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    Future<String> f1 = Future.future();
    vertx.executeBlocking(f -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println("f1 is still running");
      f.complete("f1 succeed");
    }, f1.completer());

    Future<String> f2 = Future.future();
    vertx.executeBlocking(f -> {
      f.fail(new RuntimeException("f2 failed"));
    }, f2.completer());

    CompositeFuture all = CompositeFuture.all(f1, f2);

    all.setHandler(rs -> {
      if (rs.succeeded()) {
        System.out.println(rs.result());
      } else {
        System.out.println(rs.cause());
      }
    });
  }
}

package examples;

import io.vertx.core.Context;
import io.vertx.core.Vertx;

public class NonBlockingExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    // Context和Handler是Vert.x中最核心的两个类。
    // Handler 是事件处理器
    // Context 是事件执行的上下文环境
    Context context = vertx.getOrCreateContext();

    // Handler和Context是一对多的关系，一个Handler只能在它注册的Context上执行，
    // 一个Context可以执行多个Handler。
    context.runOnContext(v -> {
      System.out.println("Hello Vert.x");
    });

  }
}

package examples;

import io.vertx.core.AbstractVerticle;

public class ExampleVerticle extends AbstractVerticle {
  @Override public void start() throws Exception {
    System.out.println("verticle started.");
  }

  @Override public void stop() throws Exception {
    System.out.println("verticle stopped.");
  }
}

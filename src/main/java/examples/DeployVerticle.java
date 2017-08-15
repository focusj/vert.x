package examples;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

//Vert.x的verticle部署方式和Actor非常类似，逻辑上Verticle和Actor是等价的。和Actor一样Verticle也可以构建成树状的结构
//这只是从部署方式来对比两者，两者在理念上还有很大的差别。
public class DeployVerticle {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    // 实例部署
    // 这种部署方式有一些弊端：
    //    1. 不支持多实例部署
    //    2. 不支持Isolation Group
    DeploymentOptions opts = new DeploymentOptions().setWorker(true);
    vertx.deployVerticle(new ExampleVerticle(), opts);

    // 反射部署
    vertx.deployVerticle(ExampleVerticle.class.getName());
  }
}

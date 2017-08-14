package examples;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageProducer;

public class EventBusSendExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    EventBus eventBus = vertx.eventBus();

    String ADDRESS = "address";

    eventBus.consumer(ADDRESS, event -> {
      event.reply("pong");
    });

    eventBus.send("address", "ping");

    MessageProducer<Object> sender = eventBus.sender(ADDRESS);
    sender.send("ping");

  }
}

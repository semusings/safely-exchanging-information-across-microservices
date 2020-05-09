package io.github.bhuwanupadhyay.order.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderEventSource {

  String PAYMENT_RECEIVED = "paymentReceived";

  @Output("paymentRequested")
  MessageChannel paymentRequested();

  @Output(PAYMENT_RECEIVED)
  SubscribableChannel paymentReceived();
}

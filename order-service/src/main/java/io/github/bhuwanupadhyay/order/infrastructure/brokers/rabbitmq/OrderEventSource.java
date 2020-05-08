package io.github.bhuwanupadhyay.order.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderEventSource {

  @Output("requestPayment")
  MessageChannel requestPayment();
}

package io.github.bhuwanupadhyay.order.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderEventSource {

  String PAYMENT_RECEIVED_CHANNEL = "paymentReceivedChannel";

  @Output("paymentRequestedChannel")
  MessageChannel paymentRequested();

  @Input(PAYMENT_RECEIVED_CHANNEL)
  SubscribableChannel paymentReceived();
}

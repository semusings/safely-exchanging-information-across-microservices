package io.github.bhuwanupadhyay.payment.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentEventSource {

  String PAYMENT_REQUESTED = "paymentRequested";

  @Output(PAYMENT_REQUESTED)
  SubscribableChannel paymentRequested();

  @Output("paymentReceived")
  MessageChannel paymentReceived();
}

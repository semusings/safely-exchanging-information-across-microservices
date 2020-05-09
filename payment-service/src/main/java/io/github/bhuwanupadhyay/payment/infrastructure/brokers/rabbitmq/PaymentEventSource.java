package io.github.bhuwanupadhyay.payment.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentEventSource {

  String PAYMENT_REQUESTED_CHANNEL = "paymentRequestedChannel";

  @Input(PAYMENT_REQUESTED_CHANNEL)
  SubscribableChannel paymentRequested();

  @Output("paymentReceivedChannel")
  MessageChannel paymentReceived();
}

package io.github.bhuwanupadhyay.order.application.internal.outboundservices;

import io.github.bhuwanupadhyay.order.infrastructure.brokers.rabbitmq.OrderEventSource;
import io.github.bhuwanupadhyay.schemas.PaymentRequested;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(OrderEventSource.class)
@RequiredArgsConstructor
public class OrderEventPublisherService {
  private final OrderEventSource orderEventSource;

  @TransactionalEventListener // Attach it to the transaction of the repository operation
  public void handlePaymentReceived(PaymentRequested paymentRequested) {
    orderEventSource
        .requestPayment()
        .send(MessageBuilder.withPayload(paymentRequested).build()); // Publish the event
  }
}

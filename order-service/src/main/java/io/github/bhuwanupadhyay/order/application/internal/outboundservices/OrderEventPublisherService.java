package io.github.bhuwanupadhyay.order.application.internal.outboundservices;

import io.github.bhuwanupadhyay.order.domain.events.PaymentRequestedEvent;
import io.github.bhuwanupadhyay.order.infrastructure.brokers.rabbitmq.OrderEventSource;
import io.github.bhuwanupadhyay.schemas.PaymentRequested;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@EnableBinding(OrderEventSource.class)
@RequiredArgsConstructor
public class OrderEventPublisherService {
  private final OrderEventSource orderEventSource;

  @TransactionalEventListener // Attach it to the transaction of the repository operation
  public void handlePaymentRequestedEvent(PaymentRequestedEvent paymentRequestedEvent) {
    LOG.info("Handling event [PaymentRequestedEvent].");
    final PaymentRequested paymentRequested =
        PaymentRequested.newBuilder()
            .setOrderId(paymentRequestedEvent.getOrderId().getOrderId())
            .setOrderAmount(paymentRequestedEvent.getOrderAmount().asString())
            .setCustomerId(paymentRequestedEvent.getCustomerId().getCustomerId())
            .build();
    orderEventSource
        .paymentRequested()
        .send(MessageBuilder.withPayload(paymentRequested).build()); // Publish the event
    LOG.info("Successfully published the event [PaymentRequestedEvent].");
  }
}

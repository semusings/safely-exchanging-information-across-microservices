package io.github.bhuwanupadhyay.payment.application.internal.outboundservices;

import io.github.bhuwanupadhyay.payment.domain.events.PaymentReceivedEvent;
import io.github.bhuwanupadhyay.payment.infrastructure.brokers.rabbitmq.PaymentEventSource;
import io.github.bhuwanupadhyay.schemas.PaymentReceivedV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@EnableBinding(PaymentEventSource.class)
@RequiredArgsConstructor
public class PaymentEventPublisherService {
  private final PaymentEventSource paymentEventSource;

  @TransactionalEventListener // Attach it to the transaction of the repository operation
  public void handlePaymentReceivedEvent(PaymentReceivedEvent paymentReceivedEvent) {
    LOG.info("Handling event [PaymentReceivedEvent].");
    final PaymentReceivedV1 paymentReceived =
        PaymentReceivedV1.newBuilder()
            .setOrderId(paymentReceivedEvent.getOrderId().getOrderId())
            .setPaymentId(paymentReceivedEvent.getPaymentId().getPaymentId())
            .build();
    paymentEventSource
        .paymentReceived()
        .send(MessageBuilder.withPayload(paymentReceived).build()); // Publish the event
    LOG.info("Successfully published the event [PaymentReceivedV1].");
  }
}

package io.github.bhuwanupadhyay.payment.interfaces.events;

import io.github.bhuwanupadhyay.payment.application.internal.commandservices.CreatePaymentCommandService;
import io.github.bhuwanupadhyay.payment.domain.commands.CreatePaymentCommand;
import io.github.bhuwanupadhyay.payment.infrastructure.brokers.rabbitmq.PaymentEventSource;
import io.github.bhuwanupadhyay.schemas.PaymentRequestedV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableBinding(PaymentEventSource.class) // Bind to the channel connection for the message
public class PaymentEventHandler {

  private final CreatePaymentCommandService createPaymentCommandService;

  // Listen to the stream of messages on the destination
  @StreamListener(target = PaymentEventSource.PAYMENT_REQUESTED_CHANNEL)
  public void receiveEvent(PaymentRequestedV1 paymentRequested) {
    LOG.info("Receive event [PaymentRequestedV1].");
    LOG.debug("Event payload {}.", paymentRequested);
    final CreatePaymentCommand createPaymentCommand = new CreatePaymentCommand();
    createPaymentCommand.setOrderId(paymentRequested.getOrderId().toString());
    createPaymentCommand.setOrderAmount(paymentRequested.getOrderAmount().toString());
    createPaymentCommandService.createPayment(createPaymentCommand);
    LOG.info("Successfully processed event [PaymentRequestedV1].");
  }
}

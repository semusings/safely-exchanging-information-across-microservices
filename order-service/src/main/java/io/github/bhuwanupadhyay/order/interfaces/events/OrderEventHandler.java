package io.github.bhuwanupadhyay.order.interfaces.events;

import io.github.bhuwanupadhyay.order.application.internal.commandservices.NotifyPaymentCommandService;
import io.github.bhuwanupadhyay.order.domain.commands.NotifyPaymentCommand;
import io.github.bhuwanupadhyay.schemas.PaymentReceived;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableBinding(Sink.class) // Bind to the channel connection for the message
public class OrderEventHandler {

  private final NotifyPaymentCommandService notifyPaymentCommandService;

  @StreamListener(target = Sink.INPUT) // Listen to the stream of messages on the destination
  public void receiveEvent(PaymentReceived paymentReceived) {
    LOG.info("Receive event [PaymentReceived].");
    LOG.debug("Event payload {}.", paymentReceived);
    final NotifyPaymentCommand notifyPaymentCommand = new NotifyPaymentCommand();
    notifyPaymentCommand.setOrderId(paymentReceived.getOrderId().toString());
    notifyPaymentCommand.setPaymentId(paymentReceived.getPaymentId().toString());
    notifyPaymentCommandService.notifyPayment(notifyPaymentCommand);
    LOG.debug("Successfully processed event [PaymentReceived].");
  }
}

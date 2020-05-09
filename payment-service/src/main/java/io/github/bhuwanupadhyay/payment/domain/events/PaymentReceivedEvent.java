package io.github.bhuwanupadhyay.payment.domain.events;

import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.OrderId;
import io.github.bhuwanupadhyay.payment.domain.model.valueobjects.PaymentId;
import lombok.Getter;

@Getter
public class PaymentReceivedEvent {

  private final PaymentId paymentId;
  private final OrderId orderId;

  public PaymentReceivedEvent(PaymentId paymentId, OrderId orderId) {
    this.paymentId = paymentId;
    this.orderId = orderId;
  }
}

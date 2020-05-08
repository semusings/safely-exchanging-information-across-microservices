package io.github.bhuwanupadhyay.order.domain.events;

import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderAmount;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import lombok.Getter;

@Getter
public class PaymentRequestedEvent {

  private final OrderId orderId;
  private final OrderAmount orderAmount;

  public PaymentRequestedEvent(OrderId orderId, OrderAmount orderAmount) {
    this.orderId = orderId;
    this.orderAmount = orderAmount;
  }
}

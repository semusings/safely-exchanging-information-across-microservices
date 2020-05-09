package io.github.bhuwanupadhyay.order.domain.events;

import io.github.bhuwanupadhyay.order.domain.model.valueobjects.CustomerId;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderAmount;
import io.github.bhuwanupadhyay.order.domain.model.valueobjects.OrderId;
import lombok.Getter;

@Getter
public class PaymentRequestedEvent {

  private final OrderId orderId;
  private final CustomerId customerId;
  private final OrderAmount orderAmount;

  public PaymentRequestedEvent(OrderId orderId, CustomerId customerId, OrderAmount orderAmount) {
    this.orderId = orderId;
    this.customerId = customerId;
    this.orderAmount = orderAmount;
  }
}

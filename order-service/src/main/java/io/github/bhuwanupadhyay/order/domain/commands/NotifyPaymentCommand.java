package io.github.bhuwanupadhyay.order.domain.commands;

import lombok.Data;

@Data
public class NotifyPaymentCommand {

  private String orderId;
  private String paymentId;
}
